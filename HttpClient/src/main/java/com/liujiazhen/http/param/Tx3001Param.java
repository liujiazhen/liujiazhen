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

        pkgBody.put("draftNo", "290765100004320200805013903903"); // 票据号码
        pkgBody.put("endrsmtDate", "20200807"); // 业务申请日期
        pkgBody.put("endrsrRole", "RC01"); // 背书人类别
        pkgBody.put("endrsrName", "新希望化工投资有限公司"); // 背书人名称
        pkgBody.put("endrsrCmonid", "79217138-4"); // 背书人组织机构代码
        pkgBody.put("endrsrAcctid", "100301011000"); // 背书人账号
        pkgBody.put("endrsrAcctsvcr", "907651000043"); // 背书人开户行行号
        pkgBody.put("endrsrAcctsvcrname", "新希望财务有限公司"); // 背书人开户行名称
        pkgBody.put("endrseeAcctid", "100301011000"); // 被背书人账号
        pkgBody.put("endrseeName", "新希望财务有限公司"); // 被背书人名称
        pkgBody.put("endrseeAcctsvcr", "907651000043"); // 被背书人开户行行号
        pkgBody.put("endrseeAcctsvcrName", "新希望财务有限公司"); // 被背书人开户行名称
        pkgBody.put("bizEndrsmtmk", "2"); // 转让标识

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
