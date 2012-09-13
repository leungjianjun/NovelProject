package com.woshuwu.controller;

import com.woshuwu.dao.impl.TestDaoImpl;
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

    private TestDaoImpl testDaoImpl;

    @RequestMapping("index.do")
    public String home(ModelMap model){
        User user = new User();
        user.setId(1);
        user.setNickName("Jeans");
        model.addAttribute("usr1",user);
        testDaoImpl.test();
        return "home";
    }

    public TestDaoImpl getTestDaoImpl() {
        return testDaoImpl;
    }

    @Autowired
    public void setTestDaoImpl(TestDaoImpl testDaoImpl) {
        this.testDaoImpl = testDaoImpl;
    }
}
