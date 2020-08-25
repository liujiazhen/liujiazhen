package org.liujiazhen.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String sayHello() {
        return "index.html";
    }

    @RequestMapping("/index_v1")
    public String sayHello23() {
        return "index_v1";
    }

    @RequestMapping("/liujiazhen")
    public ModelAndView liujiazhen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "liujiazhne");
        modelAndView.setViewName("liujiazhen");
        return modelAndView;
    }
}
