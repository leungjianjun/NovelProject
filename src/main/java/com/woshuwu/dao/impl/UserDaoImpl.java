package com.woshuwu.dao.impl;

import com.woshuwu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-20
 * Time: 下午11:42
 */
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
}
