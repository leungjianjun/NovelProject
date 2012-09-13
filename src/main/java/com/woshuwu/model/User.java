package com.woshuwu.model;

/**
 * 注册用户
 * Author: ljj
 * Date: 12-8-28
 * Time: 下午6:51
 */
public class User {

    private  int id;

    private String nickName;

    private String account;

    private String email;

    private String mobile;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
