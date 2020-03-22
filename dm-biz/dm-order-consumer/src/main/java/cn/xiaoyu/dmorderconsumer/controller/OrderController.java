package cn.xiaoyu.dmorderconsumer.controller;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.vo.CreateOrderVo;
import cn.xiaoyu.dmorderconsumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @PostMapping("/createOrder")
    public Dto createOrder(@RequestBody CreateOrderVo orderVo) {
        return orderService.createOrder(orderVo);
    }
}
