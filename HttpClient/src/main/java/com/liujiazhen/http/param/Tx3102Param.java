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

        pkgBody.put("draftNo", "190765100004320200901014630460");
        pkgBody.put("accptncUcondlconsgnmtmrk", "CC00");
        pkgBody.put("accptncApplydate", "20200903");
        pkgBody.put("accptrName", "新希望化工投资有限公司");
        pkgBody.put("accptrRole", "RC05");
        pkgBody.put("accptrOrgid", "56717837-9");
        pkgBody.put("accptrElctrncSgntr", "0");
        pkgBody.put("accptrAcctid", "0");
        pkgBody.put("accptrAcctsvcr", "907651000043");
        pkgBody.put("accptrAcctsvcrName", "新希望财务有限公司");
        pkgBody.put("accptncUcondlprmsmrk", "CC00");

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
    public static String getParam2(String serialNo) {
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

        pkgBody.put("draftNo", "290765100004320200805013903903");
        pkgBody.put("accptncUcondlconsgnmtmrk", "CC00");
        pkgBody.put("accptncApplydate", "20200806");
        pkgBody.put("accptrName", "新希望化工投资有限公司");
        pkgBody.put("accptrRole", "RC01");
        pkgBody.put("accptrOrgid", "79217138-4");
        pkgBody.put("accptrElctrncSgntr", "0");
        pkgBody.put("accptrAcctid", "100301011000");
        pkgBody.put("accptrAcctsvcr", "907651000043");
        pkgBody.put("accptrAcctsvcrName", "新希望财务有限公司");
        pkgBody.put("accptncUcondlprmsmrk", "CC00");

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }

}
