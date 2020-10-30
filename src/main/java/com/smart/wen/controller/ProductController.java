package com.smart.wen.controller;

import com.smart.wen.entity.TProduct;
import com.smart.wen.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("/list")
    public List<TProduct> list(){
        List<TProduct> list=null;
        try {
            list=productService.findALl();
        } catch (Exception e) {

        }
        return list;
    }

}
