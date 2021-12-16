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

        pkgBody.put("guarnteeType", "GT01"); // 保证类型
        pkgBody.put("draftNo", "190765100004320200902014645788"); // 票据号码
        pkgBody.put("guarnteeDate", "20200806"); // 业务申请日期
        pkgBody.put("warnteeName", "新希望化工投资有限公司"); // 被保证人名称
        pkgBody.put("warnteeRole", "RC01"); // 被保证人类别
        pkgBody.put("warnteeAcctid", "100301011000"); // 被保证人账号
        pkgBody.put("warnteeCmonid", "79217138-4"); // 被保证人组织机构代码
        pkgBody.put("warnteeAcctsvcrName", "新希望财务有限公司"); // 被保证人开户行名称
        pkgBody.put("warnteeAcctsvcr", "907651000043"); // 被保证人开户行行号
        pkgBody.put("guarntrAcctId", "108607011000"); // 保证人账户
        pkgBody.put("guarntrName", "普惠农牧融资担保有限公司"); // 保证人名称
        pkgBody.put("guarntrAcctsvcr", "907651000043"); // 保证人开户行号
        pkgBody.put("guarntrAcctsvcrName", "新希望财务有限公司"); // 保证人开户行名称
        pkgBody.put("guarnteeRmrkbypropsr", "this is remark"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
    public static String getParam2(String serialNo) {
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

        pkgBody.put("guarnteeType", "GT01"); // 保证类型
        pkgBody.put("draftNo", "290765100004320200805013903903"); // 票据号码
        pkgBody.put("guarnteeDate", "20200806"); // 业务申请日期
        pkgBody.put("warnteeName", "新希望化工投资有限公司"); // 被保证人名称
        pkgBody.put("warnteeRole", "RC01"); // 被保证人类别
        pkgBody.put("warnteeAcctid", "100301011000"); // 被保证人账号
        pkgBody.put("warnteeCmonid", "79217138-4"); // 被保证人组织机构代码
        pkgBody.put("warnteeAcctsvcrName", "新希望财务有限公司"); // 被保证人开户行名称
        pkgBody.put("warnteeAcctsvcr", "907651000043"); // 被保证人开户行行号
        pkgBody.put("guarntrAcctId", "108607011000"); // 保证人账户
        pkgBody.put("guarntrName", "普惠农牧融资担保有限公司"); // 保证人名称
        pkgBody.put("guarntrAcctsvcr", "907651000043"); // 保证人开户行号
        pkgBody.put("guarntrAcctsvcrName", "新希望财务有限公司"); // 保证人开户行名称
        pkgBody.put("guarnteeRmrkbypropsr", "this is remark"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
/*
ecd3106Input.setGuarnteeType("GT01");
ecd3106Input.setDraftNo("290765100004320200805013903903");
ecd3106Input.setGuarnteeDate(DateUtil.format(new Date(), DateUtil.PATTERN_yyyyMMdd));
ecd3106Input.setWarnteeName("新希望化工投资有限公司");
ecd3106Input.setWarnteeRole("RC01");
ecd3106Input.setWarnteeAcctid("100301011000");
ecd3106Input.setWarnteeCmonid("79217138-4");
ecd3106Input.setWarnteeAcctsvcrName("新希望财务有限公司");
ecd3106Input.setWarnteeAcctsvcr("907651000043");
ecd3106Input.setGuarntrAcctid("108607011000");
ecd3106Input.setGuarntrName("普惠农牧融资担保有限公司");
ecd3106Input.setGuarntrAcctsvcr("907651000043");
ecd3106Input.setGuarntrAcctsvcrName("新希望财务有限公司");

 */