package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3002Param {
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
        reqPkgHead.put("bsnCode", "3002");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftNo", ""); // 票据号码
        pkgBody.put("bnkEndrsmtmk", "100"); // 不得转让标记
        pkgBody.put("dscntApplydate", "20200720"); // 贴现申请日期
        pkgBody.put("dscntRpdmk", "232"); // 贴现种类
        pkgBody.put("dscntIntrstrate", "3"); // 贴现利率%(年)
        pkgBody.put("dscntInterest", "100"); // 贴现利息
        pkgBody.put("dscntAmt", "1000"); // 贴现实付金额
        pkgBody.put("dscntSttlmmk", "11"); // 线上清算标记
        pkgBody.put("dscntRpdopendt", "20200720"); // 赎回开放日
        pkgBody.put("dscntRpdduedt", "20200720"); // 赎回截止日
        pkgBody.put("dscntRpdintrstrate", "3"); // 贴现赎回利率%(年)
        pkgBody.put("dscntRpdamt", "600"); // 贴现赎回金额
        pkgBody.put("bizEndrsmtmk", "2"); // 业务转让标记
        pkgBody.put("aoaccninfAcctid", "20211231"); // 入账账号
        pkgBody.put("aoaccninfAcctsvcr", "25040056"); // 入账开户行号
        pkgBody.put("dscntpropsrRole", "22"); // 贴出人类别
        pkgBody.put("dscntpropsrName", "新希望六和股份有限公司"); // 贴出人名称
        pkgBody.put("dscntpropsrCmonid", "12316546"); // 贴出人组织机构代码
        pkgBody.put("dscntpropsrAcctid", "907651000043"); // 贴出人账号
        pkgBody.put("dscntpropsrAcctsvcr", "100301011000"); // 贴出人开户行行号
        pkgBody.put("dscntpropsrAcctsvcrName", "新希望化工投资有限公司"); // 贴出人开户行名称
        pkgBody.put("dscntbkAcctid", "907651000043"); // 贴入人账号
        pkgBody.put("dscntbkName", "新希望财务有限公司"); // 贴入人名称
        pkgBody.put("dscntbkAcctsvcr", "012200111111"); // 贴入人开户行行号
        pkgBody.put("dscntbkAcctsvcrName","新希望化工投资有限公司"); // 贴入人开户行名称

        pkgBody.put("payerAcctid","25040056"); // 付息人账号
        pkgBody.put("payerName","新希望化工投资有限公司"); // 付息人名称
        pkgBody.put("payerAcctsvcr","100301011000"); // 付息人开户行行号
        pkgBody.put("payerAcctsvcrName","新希望化工投资有限公司"); // 付息人开户行名称



        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
