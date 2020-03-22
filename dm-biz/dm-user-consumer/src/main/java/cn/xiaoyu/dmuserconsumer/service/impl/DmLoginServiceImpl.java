package cn.xiaoyu.dmuserconsumer.service.impl;

import cn.xiaoyu.common.client.client.RestDmImageClient;
import cn.xiaoyu.common.client.client.RestDmUserClient;
import cn.xiaoyu.common.module.pojo.DmImage;
import cn.xiaoyu.common.module.pojo.DmUser;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.RedisUtils;
import cn.xiaoyu.common.vo.DmUserVo;
import cn.xiaoyu.common.vo.TokenVo;
import cn.xiaoyu.dmuserconsumer.service.DmLoginService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DmLoginServiceImpl implements DmLoginService {
    @Autowired
    private RestDmUserClient restDmUserClient;
    @Autowired
    private RestDmImageClient restDmImageClient;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Object[] login(DmUser user) {
        //验证用户登陆是否成功
        DmUser dmUser = restDmUserClient.checkLoginByPassword(user);
        if (EmptyUtils.isEmpty(dmUser)) {
            return null;
        }
        //组装信息
        DmUserVo dmUserVo = new DmUserVo();
        BeanUtils.copyProperties(dmUser, dmUserVo);
        dmUserVo.setUserId(dmUser.getId());
        //更新用户头像
        List<DmImage> dmImageList = restDmImageClient.queryDmImageList(dmUser.getId(),
                Constants.Image.ImageType.NORMAL,
                Constants.Image.ImageCategory.USER);
        if (EmptyUtils.isNotEmpty(dmImageList)) {
            dmUserVo.setImageId(dmImageList.get(0).getId());
            dmUserVo.setImgUrl(dmImageList.get(0).getImgUrl());
        }
        //生成用户token
        String token = this.generateToken(dmUser);
        //保存token到redis中
        this.saveToken(token, dmUserVo);
        TokenVo tokenVo = new TokenVo(token, Constants.RedisExpire.SESSION_TIMEOUT, new Date().getTime());
        return new Object[]{dmUserVo, tokenVo};
    }

    @Override
    public DmUserVo loadCurrentUserByTokenAsDmUserVo(String tokenString) {
        String tokenUser = null;
        if ((tokenUser = (String) redisUtils.get(tokenString)) == null) {
            //抛出异常
            return null;
        }
        return JSONObject.parseObject(tokenUser, DmUserVo.class);
    }

    private void saveToken(String token, DmUserVo dmUserVO) {
        String tokenKey = Constants.USER_TOKEN_PREFIX + dmUserVO.getUserId();
        String tokenValue = null;
        //检查是否已经登陆，如果还在登陆有效期内，就需要删除掉原来的登陆信息
        if ((tokenValue = (String) redisUtils.get(tokenKey)) != null) {
            //代表原来用户已经登陆
            redisUtils.delete(tokenKey);
        }
        //缓存用户token
        redisUtils.set(tokenKey, Constants.RedisExpire.SESSION_TIMEOUT, token);
        //缓存用户详细信息
        redisUtils.set(token, Constants.RedisExpire.SESSION_TIMEOUT, JSON.toJSONString(dmUserVO));
    }

    private String generateToken(DmUser dmUser) {
        return restDmUserClient.generateToken(dmUser);
    }
}
