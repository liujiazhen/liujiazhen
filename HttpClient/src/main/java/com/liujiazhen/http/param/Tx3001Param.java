package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3001Param {
    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String getParam(String serialNo) {
        String isoDate = ISO_DATE.format(LocalDateTime.now());

        JSONObject jsonObject = new JSONObject();
        JSONObject reqPkgHead = new JSONObject();
        JSONObject pkgBody = new JSONObject();

        reqPkgHead.put("version", "1.0.0");
        reqPkgHead.put("appNo", "LiuHe000001");
        reqPkgHead.put("reqTime", isoDate);
        reqPkgHead.put("serialNo", serialNo);
        reqPkgHead.put("bsnCode", "3001");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftNo", "321421421"); // 票据号码
        pkgBody.put("endrsmtDate", "20200723"); // 业务申请日期
        pkgBody.put("endrsrRole", "12"); // 背书人类别
        pkgBody.put("endrsrName", "这是背书人名称"); // 背书人名称
        pkgBody.put("endrsrCmonid", "1214"); // 背书人组织机构代码
        pkgBody.put("endrsrAcctid", "321421421"); // 背书人账号
        pkgBody.put("endrsrAcctsvcr", "5546436"); // 背书人开户行行号
        pkgBody.put("endrsrAcctsvcrname", "这是背书人开户行名称"); // 背书人开户行名称
        pkgBody.put("endrseeAcctid", "154215"); // 被背书人账号
        pkgBody.put("endrseeName", "这是被背书人名称"); // 被背书人名称
        pkgBody.put("endrseeAcctsvcr", "3253532532"); // 被背书人开户行行号
        pkgBody.put("endrseeAcctsvcrName", "这是被背书人开户行名称"); // 被背书人开户行名称
        pkgBody.put("bizEndrsmtmk", "2"); // 转让标识

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
