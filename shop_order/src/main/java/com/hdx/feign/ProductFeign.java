package com.hdx.feign;

import com.hdx.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-product")
public interface ProductFeign {
    @GetMapping("product/{pid}")
    Product findByPid(@PathVariable Integer pid);
}
