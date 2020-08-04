package com.liujiazhen.http.param;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 承兑签收
 */
public class Tx3204Param {
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
        reqPkgHead.put("bsnCode", "3204");
        reqPkgHead.put("userName", "liujiazhen");
        reqPkgHead.put("busiOrg", "ssf");

        pkgBody.put("draftNo", "136546"); // 票据号码
        pkgBody.put("reCallNo", "11111111"); // 回复人账号
        pkgBody.put("reCallName", "张三"); // 回复人名称
        pkgBody.put("reCallType", "22"); // 回复人类别
        pkgBody.put("reCallOpenBank", "22222222"); // 回复人开户行行号
        pkgBody.put("reCallOpenName", "回复人开户行行名"); // 回复人开户行行名
        pkgBody.put("reCallOrgCode", "ORG"); // 回复人组织机构代码
        pkgBody.put("bizKind", "ss"); // 业务类型
        pkgBody.put("revertDate", "20200701"); // 交易签收日期
        pkgBody.put("signTag", "2"); // 签收标志
        pkgBody.put("refuseReason", "拒付理由"); // 拒付理由
        pkgBody.put("remark", "备注"); // 备注

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }
}
