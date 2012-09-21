package com.woshuwu.security;

import com.woshuwu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-20
 * Time: 下午11:35
 */
public class SecurityFilterChain extends OncePerRequestFilter implements Filter {

    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter work!");
        chain.doFilter(request,  response);
    }

    //===========setter and getter method

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
