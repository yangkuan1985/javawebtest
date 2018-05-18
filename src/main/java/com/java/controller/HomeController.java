package com.java.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {
    final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @RequestMapping("/time.json")
    public @ResponseBody Object time() throws Exception{
        Thread.sleep(5000);
        logger.warn("this is log message");;
        return new Date();
    }
}
