package com.test.opensys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wei on 14-12-14.
 */
@Controller
public class InitController {
    @RequestMapping("/index")
    public String init(Model mv){
        mv.addAttribute("test","test");
        return "test";
    }
}
