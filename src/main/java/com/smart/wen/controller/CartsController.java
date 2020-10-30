package com.smart.wen.controller;

import com.smart.wen.entity.Carts;
import com.smart.wen.request.CartsRequestParams;
import com.smart.wen.service.CartsService;
import com.smart.wen.utils.ResponseEntity;
import com.smart.wen.vo.CartsVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
 * 1.购物车功能
 * 2.产看购物车
 * 3.删除购物车
 * 4.修改商品的数量
 * 5.加入收藏夹
 * 6.添加购物车(如果存在就添加数量，不存在旧添加)
 * */
@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    CartsService cartsService;

    /*
     * 通过ID查询购物车信息
     * */
    @GetMapping("/list")
    public ResponseEntity<List<CartsVo>> list(@RequestParam("userId") int userId) {

        try {
            return ResponseEntity.success(cartsService.findAllByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.sysError();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody CartsRequestParams cartsRequestParams) {
        boolean flag = false;
        try {
            int i = cartsService.saveCarts(cartsRequestParams);
            if (i > 0) {
                return ResponseEntity.success(true);
            } else {
                return ResponseEntity.sysError();
            }
        } catch (Exception e) {
            return ResponseEntity.sysError();
        }

    }

    @DeleteMapping("/del")
    public ResponseEntity<Boolean> del(@RequestParam("cartId") int[] cartId) {

        try {
            int i = cartsService.delByCartId(cartId);
            if (i > 0) {
                return ResponseEntity.success(true);
            } else {
                return ResponseEntity.sysError();
            }
        } catch (Exception e) {
            return ResponseEntity.sysError();
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<Boolean> modify(@RequestParam("cartId") int cartId, int num) {

        try {
            int i = cartsService.updateByCartId(cartId, num);
            if (i > 0) {
                return ResponseEntity.success(true);
            } else {
                return ResponseEntity.sysError();
            }
        } catch (Exception e) {
            return ResponseEntity.sysError();
        }
    }
}
