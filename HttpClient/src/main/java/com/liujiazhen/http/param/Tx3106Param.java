package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3106Param {
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
        reqPkgHead.put("bsnCode", "3106");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("guarnteeType", "1"); // 保证类型
        pkgBody.put("draftNo", "1111111111"); // 票据号码
        pkgBody.put("guarnteeDate", "20200701"); // 业务申请日期
        pkgBody.put("warnteeName", "刘加振"); // 被保证人名称
        pkgBody.put("warnteeRole", "324"); // 被保证人类别
        pkgBody.put("warnteeAcctid", "1111111111"); // 被保证人账号
        pkgBody.put("warnteeCmonid", "1111111111"); // 被保证人组织机构代码
        pkgBody.put("warnteeAcctsvcrName", "这是开户行名称"); // 被保证人开户行名称
        pkgBody.put("warnteeAcctsvcr", "392345325"); // 被保证人开户行行号
        pkgBody.put("guarntrAcctId", "1111111111"); // 保证人账户
        pkgBody.put("guarntrName", "刘加振"); // 保证人名称
        pkgBody.put("guarntrAcctsvcr", "1895473298"); // 保证人开户行号
        pkgBody.put("guarntrAcctsvcrName", "保证人开户行名称"); // 保证人开户行名称
        pkgBody.put("guarnteeRmrkbypropsr", "this is remark"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
