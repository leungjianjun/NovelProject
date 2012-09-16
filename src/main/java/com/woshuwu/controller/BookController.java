package com.woshuwu.controller;

import com.woshuwu.dao.ChapterDao;
import com.woshuwu.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-14
 * Time: 下午8:44
 */
@Controller
public class BookController {

    //==================define dao ==============================
    private ChapterDao chapterDao;

    public String bookDetailPage(ModelMap model){
        return null;
    }

    public String bookContentsPage(ModelMap model){
        return null;
    }

    public String volumeContentsPage(ModelMap model){
        return null;
    }

    /**
     * 页面内容：章名、小说名、更新时间、正文、上一章，回目录，下一章
     * @param model
     * @return
     */
    @RequestMapping("chapter.html")
    public String chapterDetailPage(ModelMap model){
        Chapter chapter = chapterDao.queryChapterById(1);
        model.addAttribute("chapter",chapter);
        return "chapter_detail";
    }

    //==================setter and getter method======================

    public ChapterDao getChapterDao() {
        return chapterDao;
    }

    @Autowired
    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }
}
