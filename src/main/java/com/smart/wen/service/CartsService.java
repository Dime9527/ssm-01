package com.smart.wen.service;

import com.smart.wen.entity.Carts;
import com.smart.wen.request.CartsRequestParams;
import com.smart.wen.vo.CartsVo;

import java.util.List;
/**/
public interface CartsService {
    int saveCarts(CartsRequestParams cartsRequestParams);
    List<CartsVo> findAllByUserId(int userId);
    int delByCartId(int[] cartId);
    int updateByCartId(int cartId,int num);
}
