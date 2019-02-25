package com.sid.demo.entity;

import java.io.Serializable;

/**
 * (Kl8)实体类
 *
 * @author makejava
 * @since 2019-02-21 16:33:03
 */
public class Kl8 implements Serializable {
    private static final long serialVersionUID = 930867390358591169L;
    //id
    private String id;
    //奖号
    private Integer number;
    //大小（1：大，0：小）
    private Integer small;
    //单双（1：单，0：双）
    private Integer odd;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        this.small = small;
    }

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }
}