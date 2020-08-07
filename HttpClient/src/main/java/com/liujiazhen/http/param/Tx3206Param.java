package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 保证签收
 */
public class Tx3206Param {
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
        reqPkgHead.put("bsnCode", "3206");
        reqPkgHead.put("userName", "1111");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftNo", "290765100004320200805013903903"); // 票据号码
        pkgBody.put("reCallNo", "100301011000"); // 回复人账号
        pkgBody.put("reCallName", "新希望财务有限公司"); // 回复人名称
        pkgBody.put("reCallType", "RC01"); // 回复人类别
        pkgBody.put("reCallOpenBank", "907651000043"); // 回复人开户行行号
        pkgBody.put("reCallOpenName", "新希望财务有限公司"); // 回复人开户行行名
        pkgBody.put("reCallOrgCode", "79217138-4"); // 回复人组织机构代码
        pkgBody.put("bizKind", "BK03"); // 业务类型
        pkgBody.put("revertDate", "20200806"); // 交易签收日期
        pkgBody.put("signTag", "SU00"); // 签收标志
        pkgBody.put("refuseReason", ""); // 拒付理由
        pkgBody.put("remark", "备注"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
