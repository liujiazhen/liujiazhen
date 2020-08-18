package org.liujiazhen.af.service;

import org.liujiazhen.af.bean.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    public User login(String username, String password){
        //假设数据库有个用户用户名为fengqing,密码为123456
        if ("fengqing".equals(username) && "123456".equals(password)){
            return new User(1, "fengqing", "123456");
        } else {
            return null;
        }
    }

}
