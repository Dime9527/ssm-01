package com.smart.wen.mapper;

import com.smart.wen.entity.Carts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartsMapper {
    int insert(@Param("carts") Carts carts);
    Carts selectByUserIdAndProductId(@Param("userId") Integer useId,@Param("proId") Integer ProId);
    int updateById(@Param("cartId") Integer cartId, @Param("num") Integer num);
    int delById(@Param("cartId")Integer cartId);
    List<Carts> selectByUserId(@Param("userId") Integer userId);
}
