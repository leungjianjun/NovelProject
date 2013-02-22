package com.woshuwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午10:37
 */
@Controller
public class HomeController {

    @RequestMapping(value="/index.html", method= RequestMethod.GET)
    public String home(ModelMap model){
        return "index";
    }
}
