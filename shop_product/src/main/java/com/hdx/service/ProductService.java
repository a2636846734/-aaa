package com.hdx.service;

import com.hdx.domain.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}
