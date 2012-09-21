package com.woshuwu.model;

import java.util.Calendar;

/**
 * 注册用户
 * Author: ljj
 * Date: 12-8-28
 * Time: 下午6:51
 */
public class User {

    /**
     * primary key, auto increment
     */
    private  long id;

    /**
     * user's nick name, can repeat in database
     * varchar max(50)
     */
    private String nicename;

    /**
     * varchar max(50),unique
     */
    private String account;

    /**
     * datetime
     */
    private Calendar createTime;

    /**
     * varchar max(50)
     */
    private String email;

    /**
     * varchar max(20)
     */
    private String mobile;

    private Roles roles;

   //======= setter and getter method
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
