package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmItemCommentMapper;
import cn.xiaoyu.common.module.pojo.DmItemComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmItemCommentService {
    @Autowired
    private DmItemCommentMapper dmItemCommentMapper;

    @RequestMapping(value = "/getDmItemCommentById", method = RequestMethod.POST)
    public DmItemComment getDmItemCommentById(@RequestParam("id") Long id) throws Exception {
        return dmItemCommentMapper.getDmItemCommentById(id);
    }

    @RequestMapping(value = "/getDmItemCommentListByMap", method = RequestMethod.POST)
    public List<DmItemComment> getDmItemCommentListByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmItemCommentMapper.getDmItemCommentListByMap(param);
    }

    @RequestMapping(value = "/getDmItemCommentCountByMap", method = RequestMethod.POST)
    public Integer getDmItemCommentCountByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmItemCommentMapper.getDmItemCommentCountByMap(param);
    }

    @RequestMapping(value = "/qdtxAddDmItemComment", method = RequestMethod.POST)
    public Integer qdtxAddDmItemComment(@RequestBody DmItemComment dmItemComment) throws Exception {
        dmItemComment.setCreatedTime(new Date());
        return dmItemCommentMapper.insertDmItemComment(dmItemComment);
    }

    @RequestMapping(value = "/qdtxModifyDmItemComment", method = RequestMethod.POST)
    public Integer qdtxModifyDmItemComment(@RequestBody DmItemComment dmItemComment) throws Exception {
        dmItemComment.setUpdatedTime(new Date());
        return dmItemCommentMapper.updateDmItemComment(dmItemComment);
    }
}
