package org.liujiazhen.poi;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.liujiazhen.poi.entity.JsonRootBean;
import org.liujiazhen.poi.entity.SalaryModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JSONToExcel {
    public static void main(String[] args) throws IOException {
        createExcel();
    }

    public static List<SalaryModel> getJson() throws IOException {
        FileInputStream inputStream = new FileInputStream("D:/YongHu/zhuomian/JSON.txt");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();

        String s = new String(bytes);
        JsonRootBean jsonRootBean = JSON.parseObject(s, JsonRootBean.class);
        return jsonRootBean.getList();
    }

    public static void createExcel() throws IOException {
        List<SalaryModel> salaryList = getJson();
        FileOutputStream fileOut = new FileOutputStream("D:/YongHu/zhuomian/excel/workbook.xlsx");

        SXSSFWorkbook wb = new SXSSFWorkbook();
        SXSSFSheet sheet = wb.createSheet("666");

        SXSSFRow row0 = sheet.createRow(0);
        createSheetTitle(row0);
        for (int i = 0; i < salaryList.size(); i++) {
            SalaryModel model = salaryList.get(i);
            SXSSFRow row = sheet.createRow(i + 1);

            row.createCell(0).setCellValue(model.getMonth());
            row.createCell(1).setCellValue(model.getBase());
            row.createCell(2).setCellValue(model.getSubsidy());
            row.createCell(3).setCellValue(model.getDeduction());
            row.createCell(4).setCellValue(model.getReward());
            row.createCell(5).setCellValue(model.getBase() + model.getSubsidy() + model.getReward() - model.getDeduction());
            row.createCell(6).setCellValue(model.getInsurance());
            row.createCell(7).setCellValue(model.getFunds());
            row.createCell(8).setCellValue(model.getSpecialDeduction());
            row.createCell(9).setCellValue(model.getIncomeTax());
            row.createCell(10).setCellValue(model.getPayWages());
            row.createCell(11).setCellValue(model.getRemark());
            row.createCell(12).setCellValue(model.getUserName());
        }

        sheet.setColumnWidth(10, 1411);

        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }

    public static void createSheetTitle(Row row) {
        // Create a cell and put a value in it.
        row.createCell(0).setCellValue("月份");
        row.createCell(1).setCellValue("基础");
        row.createCell(2).setCellValue("伙");
        row.createCell(3).setCellValue("扣");
        row.createCell(4).setCellValue("奖");
        row.createCell(5).setCellValue("应");
        row.createCell(6).setCellValue("保");
        row.createCell(7).setCellValue("公");
        row.createCell(8).setCellValue("扣");
        row.createCell(9).setCellValue("税");
        row.createCell(10).setCellValue("发");
        row.createCell(11).setCellValue("注");
        row.createCell(12).setCellValue("人");
    }
}