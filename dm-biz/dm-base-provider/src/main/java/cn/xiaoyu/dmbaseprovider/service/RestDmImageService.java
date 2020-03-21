package cn.xiaoyu.dmbaseprovider.service;

import cn.xiaoyu.common.dao.mapper.DmImageMapper;
import cn.xiaoyu.common.module.pojo.DmImage;
import cn.xiaoyu.common.utils.Constants;
import cn.xiaoyu.common.utils.EmptyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestDmImageService {
    private static final Logger logger = LoggerFactory.getLogger(RestDmImageService.class);

    @Autowired
    private DmImageMapper dmImageMapper;

    @PostMapping(value = "/getDmImageById")
    public DmImage getDmImageById(@RequestParam("id") Long id) {
        return dmImageMapper.getDmImageById(id);
    }

    @PostMapping(value = "/getDmImageListByMap")
    public List<DmImage> getDmImageListByMap(@RequestParam Map<String, Object> param) {
        return dmImageMapper.getDmImageListByMap(param);
    }

    @PostMapping(value = "/getDmImageCountByMap")
    public Integer getDmImageCountByMap(@RequestParam Map<String, Object> param) {
        return dmImageMapper.getDmImageCountByMap(param);
    }

    @PostMapping(value = "/qdtxAddDmImage")
    public Integer qdtxAddDmImage(@RequestBody DmImage dmImage) {
        dmImage.setCreatedTime(new Date());
        return dmImageMapper.insertDmImage(dmImage);
    }

    @PostMapping(value = "/qdtxModifyDmImage")
    public Integer qdtxModifyDmImage(@RequestBody DmImage dmImage) {
        dmImage.setUpdatedTime(new Date());
        return dmImageMapper.updateDmImage(dmImage);
    }

    @PostMapping(value = "/queryDmImageList")
    public List<DmImage> queryDmImageList(@RequestParam("targetId") Long targetId,
                                          @RequestParam(value = "type", required = false) Integer type,
                                          @RequestParam(value = "category", required = false) Integer category) {
        Map<String, Object> imageParam = new HashMap<>();
        imageParam.put("targetId", targetId);
        imageParam.put("type", type);
        imageParam.put("category", category);
        List<DmImage> dmImageList = dmImageMapper.getDmImageListByMap(imageParam);
        setDefaultImgList(dmImageList, category, type);

        return dmImageList;
    }

    private List<DmImage> setDefaultImgList(List<DmImage> dmImages, Integer category, Integer type) {
        if (EmptyUtils.isEmpty(dmImages)) {
            logger.info("[setDefaultImgList]" + "没有查询到任何图片");
            dmImages = new ArrayList<>();
            DmImage dmImage = new DmImage();
            dmImage.setCategory(category);
            dmImage.setType(type);
            dmImages.add(dmImage);
        }
        dmImages.forEach(this::setDefaultImg);
        return dmImages;
    }

    private void setDefaultImg(DmImage dmImage) {
        if (EmptyUtils.isEmpty(dmImage)) {
            dmImage = new DmImage();
        }
        String defaultImg = null;
        if (EmptyUtils.isEmpty(dmImage.getCategory())) {
            logger.info("[setDefaultImg]" + "category为空，则设置为默认图片DEFAULT_NORMAL");
            defaultImg = Constants.DEFAULT_NORMAL;
        } else if (dmImage.getCategory().equals(Constants.Image.ImageCategory.USER)) {
            logger.info("[setDefaultImg]" + "category为0，则设置为用户默认图片DEFAULT_USER");
            defaultImg = Constants.DEFAULT_USER;
        } else if (dmImage.getCategory().equals(Constants.Image.ImageCategory.ITEM)) {
            if (dmImage.getType().equals(Constants.Image.ImageType.NORMAL)) {
                logger.info("[setDefaultImg]" + "category为1，type为0");
                defaultImg = Constants.DEFAULT_NORMAL;
            } else if (dmImage.getType().equals(Constants.Image.ImageType.CAROUSEL)) {
                logger.info("[setDefaultImg]" + "category为1，type为1");
                defaultImg = Constants.DEFAULT_CAROUSEL;
            } else if (dmImage.getType().equals(Constants.Image.ImageType.POSTER)) {
                logger.info("[setDefaultImg]" + "category为1，type为2");
                defaultImg = Constants.DEFAULT_POSTER;
            }
        }
        dmImage.setImgUrl(EmptyUtils.isNotEmpty(dmImage.getImgUrl()) ? dmImage.getImgUrl() : defaultImg);
        dmImage.setImgUrl(Constants.FILE_PRE + dmImage.getImgUrl());
    }
}
