package org.liujiazhen.af.controller;


import com.alibaba.fastjson.JSONObject;
import org.liujiazhen.af.bean.Dto;
import org.liujiazhen.af.bean.User;
import org.liujiazhen.af.service.TokenService;
import org.liujiazhen.af.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request){
        Dto dto = new Dto();

        User user = this.userService.login(username, password);
        if (user != null) {//登录成功生成token并保存token
            String userAgent = request.getHeader("user-agent");
            String token = this.tokenService.generateToken(userAgent, username);
            this.tokenService.saveToken(token, user);

            dto.setIsLogin("true");
            dto.setToken(token);
            dto.setTokenCreatedTime(System.currentTimeMillis());
            dto.setTokenExpiryTime(System.currentTimeMillis() + 2*60*60*1000);

        } else {
            dto.setIsLogin("false");
        }
        return JSONObject.toJSONString(dto);
    }
}