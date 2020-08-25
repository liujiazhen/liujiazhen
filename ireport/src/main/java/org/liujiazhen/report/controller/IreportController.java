package org.liujiazhen.report.controller;

import net.sf.jasperreports.engine.JRException;
import org.liujiazhen.report.service.IreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IreportController {
    @Autowired
    private IreportService ireportService;

    @RequestMapping("/front")
    @ResponseBody
    public Map<String, Object> front(String draftNo, HttpServletResponse response) throws JRException {
        if (draftNo == null || draftNo.length() != 30) {
            return get("000001", "票据号码错误");
        }
        byte[] front = ireportService.front(draftNo);

        if (front == null) {
            return get("000001", "生成PDF失败");
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
            return get("000001", "系统错误");
        }
    }

    @RequestMapping("/back")
    @ResponseBody
    public Map<String, Object> back(String draftNo, HttpServletResponse response) throws JRException {
        if (draftNo == null || draftNo.length() != 30) {
            return get("000001", "票据号码错误");
        }
        byte[] back = ireportService.back(draftNo);
        if (back == null) {
            return get("000001", "生成PDF失败");
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
            return get("000001", "系统错误");
        }
    }

    Map<String, Object> get(String code, String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("returnCode", code);
        map.put("returnMsg", msg);
        return map;
    }
}
