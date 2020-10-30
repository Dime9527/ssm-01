package com.smart.wen.service;

import com.smart.wen.entity.TProduct;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public List<TProduct> findALl();
}
