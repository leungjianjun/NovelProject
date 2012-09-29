package com.woshuwu.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午4:55
 */
public enum Authentication {
    //define the authentication
    COMMON_USER_CHANGE_USER_INFO;

    /**
     *
     * @param role
     * @return all authentications of the role
     */
    public static Authentication[] getAllAuthentications(int role){
        switch (role){
            case Roles.COMMON_USER:
                return new Authentication[]{COMMON_USER_CHANGE_USER_INFO};
            case Roles.VIP_USER:
                return new Authentication[]{};
            default:
                return new Authentication[]{};
        }
    }

}
