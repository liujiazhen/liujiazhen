package org.liujiazhen.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @RequestMapping("/test")
    public Object test() {
        Map<String, String> map = new HashMap<>();
        map.put("ss1", "d");
        map.put("ss2", "d");
        map.put("ss3", "d");
        map.put("ss4", "d");
        map.put("ss5", "d");
        return map;
    }

    public static void main(String[] args) {
        int count = 0;
        long tmp = System.currentTimeMillis();
        for (int x = 0; x < 1000000; x++) {
            long l = System.currentTimeMillis();
            if (tmp == l) {
                count++;
            } else {
                System.out.println(count);
                tmp = System.currentTimeMillis();
                count = 0;
            }
        }
    }
}