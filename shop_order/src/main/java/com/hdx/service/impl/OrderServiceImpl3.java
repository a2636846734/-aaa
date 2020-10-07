package com.hdx.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

//@Service
public class OrderServiceImpl3 {

    //定义资源 value指定资源名称
    @SentinelResource("message")
    public String message(){
       return "message";
   }
}
