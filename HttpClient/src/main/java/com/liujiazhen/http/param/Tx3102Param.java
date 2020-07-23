package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;
import com.liujiazhen.util.RandomUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3102Param {
    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String getParam(String serialNo) {
        JSONObject jsonObject = new JSONObject();
        JSONObject reqPkgHead = new JSONObject();
        JSONObject pkgBody = new JSONObject();

        String isoDate = ISO_DATE.format(LocalDateTime.now());
        reqPkgHead.put("version", "1.0.0");
        reqPkgHead.put("appNo", "LiuHe000001");
        reqPkgHead.put("reqTime", isoDate);
        reqPkgHead.put("serialNo", serialNo);
        reqPkgHead.put("bsnCode", "3102");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        LocalDateTime of = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        String randomNumString = RandomUtils.getRandomNumString(30);

        pkgBody.put("draftNo", randomNumString);
        pkgBody.put("accptncUcondlconsgnmtmrk", "CC00");
        pkgBody.put("accptncApplydate", ISO_DATE.format(of));
        pkgBody.put("accptrRole", "11");
        pkgBody.put("accptrOrgid", "2222");
        pkgBody.put("accptrElctrncSgntr", "0");
        pkgBody.put("accptrAcctid", "6227001111111111111");
        pkgBody.put("accptrAcctsvcr", "9001");
        pkgBody.put("accptrAcctsvcrName", "建设银行");
        pkgBody.put("accptncUcondlprmsmrk", "CC00");

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }

}
