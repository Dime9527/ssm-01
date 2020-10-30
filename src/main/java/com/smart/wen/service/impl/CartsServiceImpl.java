package com.smart.wen.service.impl;


import com.smart.wen.entity.Carts;
import com.smart.wen.exception.ServiceException;
import com.smart.wen.mapper.CartsMapper;
import com.smart.wen.request.CartsRequestParams;
import com.smart.wen.service.CartsService;
import com.smart.wen.utils.ColaBeanUtils;
import com.smart.wen.utils.ErrorStatus;
import com.smart.wen.vo.CartsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {
    @Resource
    CartsMapper cartsMapper;
    @Override
    public int saveCarts(CartsRequestParams cartsRequestParams) {
        int temp=0;
        try {
            Carts carts1 = cartsMapper.selectByUserIdAndProductId(cartsRequestParams.getUserId(), cartsRequestParams.getProductId());
            //判断是否存，创建或更新数量
            if (carts1 !=null){
                int num=carts1.getNum()+cartsRequestParams.getNum();
                temp = cartsMapper.updateById(carts1.getCartsId(), num);
            }else {
                //涉及到请求参数和持久化对象的转化问题
                Carts carts = new Carts();
                BeanUtils.copyProperties(cartsRequestParams,carts);
                temp = cartsMapper.insert(carts);
            }
        } catch (BeansException e) {
            throw new ServiceException(ErrorStatus.SERVICE_ERROR.getMessage(),ErrorStatus.SERVICE_ERROR.getStatus());
        }
        return temp;
    }

    @Override
    public List<CartsVo> findAllByUserId(int userId) {
        List<Carts> carts = cartsMapper.selectByUserId(userId);
        //BeanUtils不支持list
        List<CartsVo> articleVoList = ColaBeanUtils.copyListProperties(carts, CartsVo::new);
        return articleVoList;
    }

    @Override
    public int delByCartId(int[] cartId) {
        int count=0;
        for (int i : cartId) {
            int line = cartsMapper.delById(i);
            count=line>0?count+1:count;
        }
        return count;
    }

    @Override
    public int updateByCartId(int cartId,int num) {
        int i = cartsMapper.updateById(cartId, num);
        return i;
    }

}
