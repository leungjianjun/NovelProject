package com.woshuwu.controller;

import com.woshuwu.dao.TestDao;
import com.woshuwu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-8-26
 * Time: 下午11:46
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private TestDao testDao;

    @RequestMapping("index.do")
    public String home(ModelMap model){
        User user = new User();
        user.setId(1);
        user.setNicename("Jeans");
        model.addAttribute("usr1",user);
        testDao.test();
        return "home";
    }

    public TestDao getTestDao() {
        return testDao;
    }

    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
