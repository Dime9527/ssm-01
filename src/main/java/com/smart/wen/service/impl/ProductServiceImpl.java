package com.smart.wen.service.impl;

import com.smart.wen.entity.TProduct;
import com.smart.wen.mapper.ProductMapper;
import com.smart.wen.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public List<TProduct> findALl() {
        return productMapper.selectAll();
    }
}
