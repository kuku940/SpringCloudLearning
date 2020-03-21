package cn.xiaoyu.dmitemprovider.service;

import cn.xiaoyu.common.dao.mapper.DmItemCommentMapper;
import cn.xiaoyu.common.module.pojo.DmItemComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RestDmItemCommentService {
    @Autowired
    private DmItemCommentMapper dmItemCommentMapper;

    @PostMapping(value = "/getDmItemCommentById")
    public DmItemComment getDmItemCommentById(@RequestParam("id") Long id) {
        return dmItemCommentMapper.getDmItemCommentById(id);
    }

    @PostMapping(value = "/getDmItemCommentListByMap")
    public List<DmItemComment> getDmItemCommentListByMap(@RequestParam Map<String, Object> param) {
        return dmItemCommentMapper.getDmItemCommentListByMap(param);
    }

    @PostMapping(value = "/getDmItemCommentCountByMap")
    public Integer getDmItemCommentCountByMap(@RequestParam Map<String, Object> param) {
        return dmItemCommentMapper.getDmItemCommentCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmItemComment")
    public Integer qdtxAddDmItemComment(@RequestBody DmItemComment dmItemComment) {
        dmItemComment.setCreatedTime(new Date());
        return dmItemCommentMapper.insertDmItemComment(dmItemComment);
    }

    @PostMapping(value = "/qdtxModifyDmItemComment")
    public Integer qdtxModifyDmItemComment(@RequestBody DmItemComment dmItemComment) {
        dmItemComment.setUpdatedTime(new Date());
        return dmItemCommentMapper.updateDmItemComment(dmItemComment);
    }
}
