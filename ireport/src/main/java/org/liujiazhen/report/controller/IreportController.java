package org.liujiazhen.report.controller;

import net.sf.jasperreports.engine.JRException;
import org.liujiazhen.report.service.IreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IreportController {
    @Autowired
    private IreportService ireportService;

    @RequestMapping("/front")
    public String front(HttpServletRequest request, HttpServletResponse response) throws JRException {
        byte[] front = ireportService.front();

        if (front == null) {
            response.setContentType("text/javascript; charset=utf-8");
            return get();
        }
        try {
            response.setContentType("application/pdf; charset=utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(front);
            outputStream.flush();
            outputStream.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            response.setContentType("text/javascript; charset=utf-8");
            return get();
        }
    }

    @RequestMapping("/back")
    public String back(HttpServletRequest request, HttpServletResponse response) throws JRException {
        byte[] back = ireportService.back();
        if (back == null) {
            response.setContentType("text/javascript; charset=utf-8");
            return get();
        }
        try {
            response.setContentType("application/pdf; charset=utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(back);
            outputStream.flush();
            outputStream.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            response.setContentType("text/javascript; charset=utf-8");
            return get();
        }
    }

    String get() {
        return "{\"ret\",\"失败\"}";
    }
}
