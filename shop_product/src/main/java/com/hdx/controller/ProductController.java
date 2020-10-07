package com.hdx.controller;

import com.alibaba.fastjson.JSON;
import com.hdx.domain.Product;
import com.hdx.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    //商品信息查询
    @GetMapping("/product/{pid}")
    public Product product(@PathVariable Integer pid) {
        log.info("接下来要进行{}号商品信息查询", pid);

        Product product = productService.findByPid(pid);

        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}
