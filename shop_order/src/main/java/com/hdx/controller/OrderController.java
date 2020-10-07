package com.hdx.controller;

import com.alibaba.fastjson.JSON;
import com.hdx.domain.Order;
import com.hdx.domain.Product;
import com.hdx.feign.ProductFeign;
import com.hdx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductFeign productFeign;

    //下单
    @GetMapping("order/prod/{pid}")
    public Order order(@PathVariable Integer pid) throws InterruptedException {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        //调用商品微服务查询商品信息
//        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
        Product product = productFeign.findByPid(pid);

        Thread.sleep(2000L);
        log.info("查询到{}号商品信息,内容是:{}", pid, JSON.toJSON(product));

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        //下单
        //orderService.createOrder(order);
        log.info("下单成功{}", JSON.toJSONString(order));
        return order;
    }

    @GetMapping("order/message")
    public String message() {
        return "测试高并发";
    }
}
