package org.liujiazhen.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloSpringbootController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloSpringbootController.class);

    @RequestMapping("/hello")
    public String say(HttpServletRequest request) {
        String path1 = ClassUtils.getDefaultClassLoader().getResource("Application.yml").getPath();
        LOG.info(path1);

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        LOG.info(rootPath);

//        String path = Class.class.getClassLoader().getResource("").getPath();
//        LOG.info("PATH:" + path);
//        rootPath = rootPath.substring(1,rootPath.indexOf("WEB-INF"));
//
//        LOG.info(rootPath);
        LOG.info("heeeeeeeeeeeeeeeeeeeeeeeeeow");
        LOG.warn("warn");
        LOG.debug("debug");
        LOG.error("error");
        return "hello,this is a springboot demo！~";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String result = "username:" + username + ",password:" + password;
        System.out.println(result);
        return (result);
    }

}
