package com.smart.wen.vo;

import lombok.Data;
//价格  = 当前价格 - 优惠价格
//作用：安全考虑，不暴露表的结构；对数据进行处理
//service层返回对象
@Data
public class CartsVo {
    private Integer cartsId;
    private Integer num;
    private Integer productId;
    private Integer userId;
    private Integer status;
}
