package com.multidruid.demo.controller;

import com.multidruid.demo.mapper.goodsdb.GoodsMapper;
import com.multidruid.demo.mapper.orderdb.OrderMapper;
import com.multidruid.demo.pojo.Goods;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentMap;

import com.multidruid.demo.pojo.Order;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private OrderMapper orderMapper;

    //商品详情 参数:商品id
    @GetMapping("/goodsinfo")
    @ResponseBody
    public Goods goodsInfo(@RequestParam(value="goodsid",required = true,defaultValue = "0") Long goodsId) {
        Goods goods = goodsMapper.selectOneGoods(goodsId);
        return goods;
    }

    @GetMapping("/orderinfo")
    @ResponseBody
    public Order orderInfo(@RequestParam(value="orderid",required = true,defaultValue = "0") Long orderId) {
        Order order = orderMapper.selectOneOrder(orderId);
        return order;
    }
}

