package org.liujiazhen.poi.test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Liu jiazhen
 */
public class PoiTest {
    public static void main(String[] args) {
        String url = "D:/tmp/MyExcel.xlsx";
        FileInputStream fs;
        try {
            fs = new FileInputStream(url);
            Workbook wb = new XSSFWorkbook(fs);
            fs.close();
            Sheet sheet = wb.getSheetAt(0);

            FileOutputStream out = new FileOutputStream(url);
            for (int i = 0; i < 20; i++) {
                sheet.shiftRows(0, sheet.getLastRowNum(), 1);
                Row row = sheet.createRow((short) (i));
                row.createCell(0).setCellValue("刘加振" + i);
            }

            out.flush();
            wb.write(out);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
