package com.common.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2018-11-12 11:30:45
 */
public class User implements Serializable {
    private static final long serialVersionUID = 166812468994671617L;
    //用户ID
    private Long id;
    //用户名
    private String name;
    //密码
    private String password;
    //手机号
    private String mobilePhone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

}