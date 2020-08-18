package org.liujiazhen.af.service;

import com.alibaba.fastjson.JSONObject;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.liujiazhen.af.bean.User;
import org.liujiazhen.af.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service("tokenService")
public class TokenService {
    @Autowired
    private RedisUtil redisUtil;


    //生成token(格式为token:设备-加密的用户名-时间-六位随机数)
    public String generateToken(String userAgent, String username) {
        StringBuilder token = new StringBuilder();
        //加token:
        token.append("token:");
        //加设备
        UserAgent userAgent1 = UserAgent.parseUserAgentString(userAgent);
        if (userAgent1.getOperatingSystem().isMobileDevice()) {
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加加密的用户名
        token.append(DigestUtils.md5Hex(username) + "-");
        //加时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //加六位随机数111111-999999
        token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        System.out.println("token=>" + token.toString());
        return token.toString();
    }

    //保存token
    public void saveToken(String token, User user) {
        //如果是PC，那么token保存两个小时；如果是MOBILE
        if (token.startsWith("token:PC")) {
            redisUtil.setex(token, 2 * 60 * 60, JSONObject.toJSONString(user));
        } else {
            redisUtil.set(token, JSONObject.toJSONString(user));
        }
    }

}
