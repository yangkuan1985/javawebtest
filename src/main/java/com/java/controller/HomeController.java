package com.java.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class HomeController {
    final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @RequestMapping("/time.json")
    public @ResponseBody Object time(HttpServletResponse response) throws Exception{
        logger.trace("this is log message");
        logger.trace(new Date().getTime());
        return new Date();
    }
}
