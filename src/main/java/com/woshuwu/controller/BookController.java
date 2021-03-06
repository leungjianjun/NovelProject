package com.woshuwu.controller;

import com.woshuwu.dao.BookDao;
import com.woshuwu.dao.CategoryDao;
import com.woshuwu.dao.ChapterDao;
import com.woshuwu.model.Book;
import com.woshuwu.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    private BookDao bookDao;

    private CategoryDao categoryDao;

    //-----------------------------------------------------------
    //--------------- Novel View Module -------------------------
    /**
     * 页面内容：章名、小说名、更新时间、正文、上一章，回目录，下一章,分类
     * @param model
     * @return
     */
    @RequestMapping(value="/chapterRead/{bookId}-{chapterId}.html", method= RequestMethod.GET)
    public String chapterReadPage(@PathVariable long bookId, @PathVariable long chapterId, ModelMap model){
        Chapter chapter = chapterDao.queryChapterById(chapterId);
        model.addAttribute("chapter",chapter);
        Book book = bookDao.queryBookById(bookId);
        book.setCategory(categoryDao.queryCategoryById(book.getCategory().getId()));
        model.addAttribute("book",book);
        model.addAttribute("previousChapterId",chapterDao.getPreviousChapterIdById(chapter.getId()));
        model.addAttribute("nextChapterId",chapterDao.getNextChapterIdById(chapter.getId()));
        return "chapter_read";
    }

    @RequestMapping(value="bookRead/{bookId}.html", method= RequestMethod.GET)
    public String bookReadPage(@PathVariable long bookId, ModelMap model){
        Book book = bookDao.queryBookById(bookId);
        book.setCategory(categoryDao.queryCategoryById(book.getCategory().getId()));
        book.setVolumes(bookDao.queryBookContentById(book.getId()));
        model.addAttribute("book",book);
        return "book_read";
    }

    @RequestMapping(value="bookIntroduce/{bookId}.html", method= RequestMethod.GET)
    public String bookIntroducePage(@PathVariable long bookId, ModelMap model){
        return "book_introduce";
    }

    @RequestMapping(value="/index.html", method= RequestMethod.GET)
    public String home(ModelMap model){

        return "home";
    }

    //------------------------------------------------------------------
    //----------------- Novel Edit Module ------------------------------
    // 小说管理模块是作者管理自己的小说的后台页面。小说的管理包括对小说的添加、修改、删除
    //对小说中卷的添加添加、修改、删除，对章节的添加、修改、删除。管理页面有个统一的风格，
    //一个侧边栏，对所有操作的集合，一个正文内容分别放对应的操作

    public String bookAddPage(){
        return null;
    }


    //==================setter and getter method======================

    public ChapterDao getChapterDao() {
        return chapterDao;
    }

    @Autowired
    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
