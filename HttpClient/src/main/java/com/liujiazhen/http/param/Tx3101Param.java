package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tx3101Param {

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
        reqPkgHead.put("bsnCode", "3101");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftType", "AC02"); // 票据类型
//        pkgBody.put("isseAmount", "100.03"); // 票面金额
        pkgBody.put("bnkEndrsmtmk", "EM01"); // 不得转让标记
        pkgBody.put("isseDate", "20200711120111"); // 出票日期
        pkgBody.put("dueDate", "20201212120101"); // 到期日
//        pkgBody.put("remark", "this is remark"); // 备注
        pkgBody.put("drwrRole", "RC01"); // 出票人类别
        pkgBody.put("drwrOrgid", "79217138-4"); // 出票人组织机构代码
        pkgBody.put("drwrAcctid", "100301011000"); // 出票人账号
        pkgBody.put("drwrCdtratgs", "10"); // 出票人信用等级
        pkgBody.put("drwrName", "新希望化工投资有限公司"); //出票人名称
        pkgBody.put("drwrCdtratgAgcy", "orgi"); // 评级机构
        pkgBody.put("drwrAcctsvcr", "907651000043"); // 出票人开户行行号
        pkgBody.put("drwrCdtratgDuedate", "20211231"); // 评级到期日
        pkgBody.put("drwrAcctsvcrName", "新希望财务有限公司"); // 出票人开户行名称
        pkgBody.put("pyeeAcctid", "100201011000"); // 收款人账号
        pkgBody.put("pyeeName", "新希望六和股份有限公司"); // 收款人名称
        pkgBody.put("pyeeAcctsvcr", "907651000043"); // 收款人开户行行号
        pkgBody.put("pyeeAcctsvcrName", "907651000043"); // 收款人开户行名称
        pkgBody.put("accptrAcctid", "100301011000"); // 承兑人账号
        pkgBody.put("accptrName", "新希望化工投资有限公司"); // 承兑人名称
        pkgBody.put("accptrAcctsvcr", "907651000043"); // 承兑人开户行行号
        pkgBody.put("accptrAcctsvcrName", "新希望财务有限公司"); // 承兑人开户行名称
        pkgBody.put("txlctrctnb", "2020-01912561-001"); // 交易合同号
        pkgBody.put("busiRemark","test 3101 出票登记");

        pkgBody.put("contractFile","合同文件名（带路径）"); //
        pkgBody.put("invoiceFile","发票文件名（带路径）"); //
        pkgBody.put("othersFile","其它文件名（带路径）"); //
        pkgBody.put("bakFile1","备用文件名1"); //
        pkgBody.put("bakFile2","备用文件名2"); // 备用文件名2
        pkgBody.put("bakFile3","备用文件名3"); // 备用文件名3
        pkgBody.put("bakFile4","备用文件名4"); // 备用文件名4
        pkgBody.put("bakFile5","备用文件名5"); // 备用文件名5

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
