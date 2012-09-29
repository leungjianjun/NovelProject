package com.woshuwu.dao.impl;

import com.woshuwu.dao.BookDao;
import com.woshuwu.model.Book;
import com.woshuwu.model.BookStatus;
import com.woshuwu.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午10:56
 */
@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

    @Autowired
    public BookDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Book queryBookById(long id) {
        Book book = (Book)this.getJdbcTemplate().queryForObject(
                "SELECT * FROM book WHERE id = ?",
                new Object[]{id},
                new RowMapper(){

                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        Book book = new Book();
                        book.setBookStatus(BookStatus.values()[rs.getInt("book_status")]);
                        Category category = new Category();
                        category.setId(rs.getInt("category_id"));
                        book.setCategory(category);
                        Calendar createTime = Calendar.getInstance();
                        createTime.setTime(rs.getTimestamp("create_time"));
                        book.setCreateTime(createTime);
                        book.setId(rs.getLong("id"));
                        book.setIntroduction(rs.getString("introduction"));
                        book.setName(rs.getString("name"));
                        Calendar updateTime = Calendar.getInstance();
                        updateTime.setTime(rs.getTimestamp("update_time"));
                        book.setUpdateTime(updateTime);
                        return book;
                    }

                });
        return book;
    }
}
