package com.hdx.controller;

import com.hdx.service.impl.OrderServiceImpl3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
//@Slf4j
public class OrderController2 {
    @Autowired
    private OrderServiceImpl3 orderServiceImpl3;

    @GetMapping("order/message1")
    public String message1() {
        orderServiceImpl3.message();
        return "测试高并发1";
    }

    @GetMapping("order/message2")
    public String message2() {
        orderServiceImpl3.message();
        return "测试高并发2";
    }
}
