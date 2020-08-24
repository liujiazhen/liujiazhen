package org.liujiazhen.report.service.impl;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.liujiazhen.report.service.IreportService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

@Service
public class IreportServiceImpl implements IreportService {
    @Override
    public byte[] back() throws JRException {
        String source = "C:/Users/Administrator/Documents/jasper/source/ecd-draft-info-back-report.jasper";
        HashMap<String, Object> map = new HashMap<>();
        map.put("groupId", "20200101");
        map.put("displayDate", "2020-08-18"); // 显示日期
        map.put("title","电  子  银  行  承  兑  汇  票"); // 1
        map.put("imageParam", "D:\\develop\\iReport\\jasperParam\\ECDS_LOGO.gif"); // logo路径，绝对路径
        map.put("isShowImage", "true"); // 是否显示logo图片，true或false
        map.put("backImage", "D:\\develop\\iReport\\jasperParam\\yinc_back.jpg"); // 背景图片路径，绝对路径
        map.put("isShowBack", "true"); // 是否显示背景图片，true或false
        map.put("fulldraftNo","130049100018320170927114080686"); // 1
        return JasperRunManager.runReportToPdf(source, map, get());
    }
    @Override
    public byte[] front() throws JRException {
        String source = "C:/Users/Administrator/Documents/jasper/source/ecd-commercial-draft-info-report.jasper";
        HashMap<String, Object> map = new HashMap<>();
        map.put("displayDate", "2020-08-18"); // 显示日期
        map.put("title", "电  子  银  行  承  兑  汇  票"); // 票据标题
        map.put("isseDate", "2020-08-18"); // 出票日期
        map.put("dueDate", "2020-08-18"); // 汇票到期日
        map.put("draftStatus", "110106买断式贴现已签收"); // 票据状态
        map.put("fulldraftNo", "130049100018320170927114080686"); // 票据号码
        map.put("drwrName", "中建二局第二建筑队"); // 出票人全称
        map.put("drwrAcctid", "6227002349193167303"); // 出票人账号
        map.put("drwrAcctsvcrName", "中国建设银行章丘支行"); // 出票人开户行
        map.put("pyeeName", "青岛港港务局"); // 收款人全称
        map.put("pyeeAcctid", "6227002349193167303"); // 收款人账号
        map.put("pyeeAcctsvcrName", "中国人们银行章丘支行"); // 收款人开户银行
        map.put("drwrGuaranteeName", "张三"); // 出票保证人名称
        map.put("drwrGuaranteeAdr", "山东省济南市章丘"); // 出票保证人地址
        map.put("drwrGuaranteeDt", "2020-08-18"); // 出票保证日期
        map.put("isseAmount", "壹分整"); // 票据金额（人民币大写）
        String isseAmount = "25642.33";

        map.put("LabelAmt11", "1"); // 十亿
        map.put("LabelAmt10", "1"); // 亿
        map.put("LabelAmt9", "1"); // 千万
        map.put("LabelAmt8", "1"); // 百万
        map.put("LabelAmt7", "1"); // 十万
        map.put("LabelAmt6", "1"); // 万
        map.put("LabelAmt5", "1"); // 千
        map.put("LabelAmt4", "1"); // 百
        map.put("LabelAmt3", "1"); // 十
        map.put("LabelAmt2", "1"); // 元
        map.put("LabelAmt1", "￥"); // 角
        map.put("LabelAmt0", "1"); // 分
        map.put("accptrName", "新希望财务公司"); // 承兑人全称
        map.put("accptrAcctid", "6227002349193167303"); // 承兑人账号
        map.put("accptrAcctsvcr", "84848-1"); // 承兑人开户行行号
        map.put("accptrAcctsvcrName", "新希望财务公司"); // 承兑人开户行名称
        map.put("txlctrctnb", "2321321321"); // 交易合同号
        map.put("bnkEndrsmtmk", "是"); // 可否转让
        map.put("Label245xxx", "试试"); // 承兑信：承兑人承兑
        map.put("Label246xxx", "杀杀杀是"); // 承兑信
        map.put("accptrGuaranteeName", "李四"); // 承兑保证人名称
        map.put("accptrGuaranteeAdr", "山东省青岛市崂山区"); // 承兑人保证人地址
        map.put("accptrGuaranteeDt", "2020-08-20"); // 承兑保证日期
        map.put("drwrCdtratgAgcy", "22"); // 出票人评级机构
        map.put("drwrCdtratgs", "99"); // 出票人信用等级
        map.put("drwrCdtratgDuedate", "2020-08-19"); // 出票人保证日期
        map.put("accptrCdtratgAgcy", "11"); // 承兑人评级机构
        map.put("accptrCdtratgs", "88"); // 承兑人信用等级
        map.put("accptrCdtratgDuedate", "2020-08-18"); // 承兑人保证日期
        map.put("imageParam", "D:\\develop\\iReport\\jasperParam\\ECDS_LOGO.gif"); // logo路径，绝对路径
        map.put("isShowImage", "true"); // 是否显示logo图片，true或false
        map.put("backImage", "D:\\develop\\iReport\\jasperParam\\yinc.jpg"); // 背景图片路径，绝对路径
        map.put("isShowBack", "true"); // 是否显示背景图片，true或false

        return JasperRunManager.runReportToPdf(source, map, new JREmptyDataSource());
    }

    private static Connection get() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@192.168.0.34:1521:NEWHOPE";
        String user = "newhope";
        String password = "NEWHOPE";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
