package com.woshuwu.dao.impl;

import com.woshuwu.dao.ChapterDao;
import com.woshuwu.model.Book;
import com.woshuwu.model.Chapter;
import com.woshuwu.model.ChapterStatus;
import com.woshuwu.model.Volume;
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
    public Chapter queryChapterById(long id) {
        Chapter chapter = (Chapter)this.getJdbcTemplate().queryForObject(
            "SELECT * FROM chapter WHERE id = ?",
            new Object[]{id},
            new RowMapper(){

                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    Chapter chapter = new Chapter();
                    chapter.setTitle(rs.getString("title"));
                    chapter.setContent(rs.getString("content"));
                    Calendar updateTime = Calendar.getInstance();
                    updateTime.setTime(rs.getTimestamp("update_time"));
                    chapter.setUpdateTime(updateTime);
                    chapter.setId(rs.getInt("id"));
                    chapter.setChapterStatus(ChapterStatus.values()[rs.getInt("chapter_status")]);
                    Volume volume = new Volume();
                    volume.setId(rs.getLong("volume_id"));
                    chapter.setVolume(volume);
                    return chapter;
                }

            });
        return chapter;
    }
}
