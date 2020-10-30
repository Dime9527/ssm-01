package com.smart.wen.request;

import lombok.Data;

/*
* 控制层的传输对象
* 购物车参数实体类
* */
@Data
public class CartsRequestParams {
    private int userId;
    private int num;
    private int productId;
}
