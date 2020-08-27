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
    public String index() {
        return "index";
    }

    @RequestMapping("/index_v1")
    public String indexV1() {
        return "index_v1";
    }

    @RequestMapping("/liujiazhen")
    public ModelAndView liujiazhen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "liujiazhne");
        modelAndView.setViewName("liujiazhen");
        return modelAndView;
    }

    @RequestMapping("/agile_board")
    public String agileBoard() {
        return "agile_board";
    }

    @RequestMapping("/article")
    public String article() {
        return "article";
    }

    @RequestMapping("/badges_labels")
    public String badgesLabels() {
        return "badges_labels";
    }

    @RequestMapping("/basic_gallery")
    public String basicGallery() {
        return "basic_gallery";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/blueimp")
    public String blueimp() {
        return "blueimp";
    }

    @RequestMapping("/buttons")
    public String buttons() {
        return "buttons";
    }

    @RequestMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    @RequestMapping("/carousel")
    public String carousel() {
        return "carousel";
    }

    @RequestMapping("/chat_view")
    public String chat_view() {
        return "chat_view";
    }

    @RequestMapping("/clients")
    public String clients() {
        return "clients";
    }

    @RequestMapping("/code_editor")
    public String code_editor() {
        return "code_editor";
    }

    @RequestMapping("/contacts")
    public String contacts() {
        return "contacts";
    }
    @RequestMapping("/css_animation")
    public String cssAnimation() {
        return "css_animation";
    }
    @RequestMapping("/diff")
    public String diff() {
        return "diff";
    }
    @RequestMapping("/draggable_panels")
    public String draggablePanels() {
        return "draggable_panels";
    }
    @RequestMapping("/empty_page")
    public String emptyPage() {
        return "empty_page";
    }
    @RequestMapping("/faq")
    public String faq() {
        return "faq";
    }

}
