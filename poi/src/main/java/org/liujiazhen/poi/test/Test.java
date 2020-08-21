package org.liujiazhen.poi.test;

import org.liujiazhen.poi.util.PoiUtils;

public class Test {

    public static void main(String[] args) {
        String filePath = "D:/tmp/MyExcel.xlsx";
        //根据文件路径获取对象
        PoiUtils.getWorkbook(filePath);
        String content = PoiUtils.readExcel(0);
        System.out.println(content);
    }
}
