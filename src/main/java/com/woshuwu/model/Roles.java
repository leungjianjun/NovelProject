package com.woshuwu.model;

/**
 * 一个简化的用户权限管理实现
 * 用户权限管理最常用的是Role Base Access Control，
 * 也可以根据实际情况省去部分的东西，既可以通过用户-角色-权限，也可以通过
 * 用户-权限实现，把数据放在数据库中，这样更改配置时就可以不用重启系统。这个
 * 简化的用户权限管理只需要在user表中增加一个user_type类型就能实现相似的功能。
 * 剩下的角色和权限定义分别在Roles类和Authentication类中。但是这个权限管理只能
 * 最多有32个角色。在角色和权限修改后需要重启系统来实现改变。用户角色的变更就
 * 在于使用一个int类型进行与或非运算。如果要增加角色类型，就必须要使用更长的int
 * 字段，如long，bigint等。
 *
 * Author: ljj
 * Date: 12-9-22
 * Time: 上午12:04
 */
public class Roles {

    /**
     * userTypes 是角色的集合，通过与或运算来增加或删除角色
     */
    private int userTypes;

    /**
     * 是否含有这个角色
     * @param role
     * @return 如果有这个角色就返回真，否则返回假
     */
    public boolean hasRole(int role){
        return (userTypes & role) != 0;
    }

    /**
     * 添加角色
     * @param role
     * @return 如果已经有这个角色了，就返回假，否则返回真
     */
    public boolean addRole(int role){
        if(hasRole(role)){
            return false;
        }else{
            userTypes |= role;
            return true;
        }
    }

    /**
     * 移出角色
     * @param role
     * @return 如果有这个角色，返回真；否则返回假
     */
    public boolean removeRole(int role){
        if(hasRole(role)){
            userTypes &= ~role;
            return true;
        }else{
            return false;
        }
    }

    //define role. we can only define 32 different roles at most

    public static final int NO_ROLE = 0x00000000;

    public static final int COMMON_USER = 0x00000001;

    public static final int VIP_USER = 0x00000002;

    //define authentication. Define the authentication of the role if needed


}
