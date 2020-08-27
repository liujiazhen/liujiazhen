package org.liujiazhen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
    @RequestMapping("/mailbox")
    public String mailbox() {
        return "mailbox";
    }

    @RequestMapping("/mail_detail")
    public String mailDetail() {
        return "mail_detail";
    }

    @RequestMapping("/mail_compose")
    public String mailCompose() {
        return "mail_compose";
    }
}