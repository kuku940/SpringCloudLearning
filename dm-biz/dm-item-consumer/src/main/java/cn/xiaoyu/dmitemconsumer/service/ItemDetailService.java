package cn.xiaoyu.dmitemconsumer.service;


import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.vo.ItemCommentVo;
import cn.xiaoyu.common.vo.ItemDetailVo;
import cn.xiaoyu.common.vo.ItemPriceVo;
import cn.xiaoyu.common.vo.ItemSchedulerVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品详情服务接口
 */
public interface ItemDetailService {

    /**
     * 根据商品id返回商品详情页
     */
    Dto<ItemDetailVo> queryItemDetail(Long id);


    /**
     * 根据商品ID查询商品排期
     */
    Dto<List<ItemSchedulerVo>> queryItemScheduler(Long id);

    /**
     * 根据商品排期查询商品价格
     */
    Dto<List<ItemPriceVo>> queryItemPrice(Long scheduleId);

    /**
     * 根据商品Id查询剧评
     */
    Dto<List<ItemCommentVo>> queryItemComment(Long id);

    /**
     * 添加剧评
     */
    Dto commitItemComment(@RequestParam("itemId") Long itemId,
                          @RequestParam("userId") Long userId,
                          @RequestParam("score") Integer score,
                          @RequestParam("comment") String comment);
}
