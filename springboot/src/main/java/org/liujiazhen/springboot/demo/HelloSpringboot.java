package org.liujiazhen.springboot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringboot {

    private static final Logger LOG = LoggerFactory.getLogger(HelloSpringboot.class);

    @RequestMapping("/hello")
    public String say() {
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
