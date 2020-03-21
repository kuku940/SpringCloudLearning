package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmImageMapper;
import cn.xiaoyu.common.module.pojo.DmImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmImageService {

    @Autowired
    private DmImageMapper dmImageMapper;

    @GetMapping(value = "/getDmImageById")
    public DmImage getDmImageById(@RequestParam("id") Long id) {
        return dmImageMapper.getDmImageById(id);
    }

    @GetMapping(value = "/getDmImageListByMap")
    public List<DmImage> getDmImageListByMap(@RequestParam Map<String, Object> param) {
        return dmImageMapper.getDmImageListByMap(param);
    }

    @GetMapping(value = "/getDmImageCountByMap")
    public Integer getDmImageCountByMap(@RequestParam Map<String, Object> param) {
        return dmImageMapper.getDmImageCountByMap(param);
    }

    @GetMapping(value = "/qdtxAddDmImage")
    public Integer qdtxAddDmImage(@RequestBody DmImage dmImage) {
        dmImage.setCreatedTime(new Date());
        return dmImageMapper.insertDmImage(dmImage);
    }

    @GetMapping(value = "/qdtxModifyDmImage")
    public Integer qdtxModifyDmImage(@RequestBody DmImage dmImage) {
        dmImage.setUpdatedTime(new Date());
        return dmImageMapper.updateDmImage(dmImage);
    }
}
