package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3107Param {
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
        reqPkgHead.put("bsnCode", "3107");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftNo", "1111111111"); // 票据号码
        pkgBody.put("draftType", "21321"); // 票据类型
        pkgBody.put("collztnDate", "20200713"); // 业务申请日期
        pkgBody.put("collztnpropsrName", "1111111111"); // 出质人名称
        pkgBody.put("collztnpropsrRole", "11"); // 出质人类别
        pkgBody.put("collztnpropsrAcctid", "1111111111"); // 出质人账号
        pkgBody.put("collztnpropsrCmonid", "1111111111"); // 出质人组织机构代码
        pkgBody.put("collztnpropsrAcctsvcrName", "1111111111"); // 出质人开户行名称
        pkgBody.put("collztnpropsrAcctsvcr", "1111111111"); // 出质人开户行行号
        pkgBody.put("collztnbkAcctid", "1111111111"); // 质权人账户
        pkgBody.put("collztnbkName", "1111111111"); // 质权人名称
        pkgBody.put("collztnbkAcctsvcr", "1111111111"); // 质权人开户行号
        pkgBody.put("collztnbkAcctsvcrName", "1111111111"); // 质权人开户行名称
        pkgBody.put("collztnRmrkbypropsr", "this is remark"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
