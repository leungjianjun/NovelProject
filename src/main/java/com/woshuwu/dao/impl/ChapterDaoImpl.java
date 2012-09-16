package com.woshuwu.dao.impl;

import com.woshuwu.dao.ChapterDao;
import com.woshuwu.model.Book;
import com.woshuwu.model.Chapter;
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
 * Date: 12-9-14
 * Time: 下午11:44
 */
@Repository
public class ChapterDaoImpl extends JdbcDaoSupport implements ChapterDao {

    @Autowired
    public ChapterDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Chapter queryChapterById(int id) {
        Chapter chapter = (Chapter)this.getJdbcTemplate().queryForObject(
            "SELECT content, title, update_time, volume_id FROM chapter WHERE id = ?",
            new Object[]{id},
            new RowMapper(){

                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    Chapter chapter = new Chapter();
                    chapter.setTitle(rs.getString("title"));
                    //chapter.setContent(rs.getString("content"));
                    //Calendar createTime = Calendar.getInstance();
                    //createTime.setTime(rs.getTimestamp("update_time"));
                    //chapter.setUpdateTime(createTime);
                    return chapter;
                }

            });
        return chapter;
    }
}
