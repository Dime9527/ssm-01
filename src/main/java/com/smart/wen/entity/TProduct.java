package com.smart.wen.entity;

import java.io.Serializable;

public class TProduct implements Serializable {
    /**
     *
     */
    private Integer productId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

