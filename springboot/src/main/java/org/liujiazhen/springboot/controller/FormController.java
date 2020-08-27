package org.liujiazhen.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    private static final Logger logger = LoggerFactory.getLogger(FormController.class);

    @RequestMapping("/form_advanced")
    public String formAdvanced() {
        return "form_advanced";
    }

    @RequestMapping("/form_basic")
    public String formBasic() {
        return "form_basic";
    }

    @RequestMapping("/form_builder")
    public String formBuilder() {
        return "form_builder";
    }

    @RequestMapping("/form_editor_md")
    public String formEditorMd() {
        return "form_editor_md";
    }

    @RequestMapping("/form_editors")
    public String formEditors() {
        return "form_editors";
    }

    @RequestMapping("/form_file_upload")
    public String formFileUpload() {
        return "form_file_upload";
    }

    @RequestMapping("/form_markdown")
    public String formMarkdown() {
        return "form_markdown";
    }

    @RequestMapping("/form_simditor")
    public String formSimditor() {
        return "form_simditor";
    }

    @RequestMapping("/form_validate")
    public String formValidate() {
        return "form_validate";
    }

    @RequestMapping("/form_webuploader")
    public String formWebuploader() {
        return "form_webuploader";
    }

    @RequestMapping("/form_wizard")
    public String formWizard() {
        return "form_wizard";
    }
}
