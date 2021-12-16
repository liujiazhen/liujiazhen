//package org.liujiazhen.poi.util;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.*;
//
///**
// * @author Liu jiazhen
// */
//public class PoiUtils {
//    /**
//     * readworkbook.
//     */
//    public static Workbook readworkbook;
//    /**
//     * readFilepath.
//     */
//    private static String readFilePath;
//    /**
//     * excel xls.
//     */
//    public static final String OFFICE_EXCEL_XLS = "xls";
//    /**
//     * excel xlsx.
//     */
//    public static final String OFFICE_EXCEL_XLSX = "xlsx";
//    private PoiUtils() {
//
//    }
//    /**
//     * 获取workbook
//     * Gets the Workbook object based on the file path.
//     * @param filepath1 filepath
//     */
//    public static void getWorkbook(final String filepath1) {
//        readFilePath = filepath1;
//        InputStream is = null;
//        if (readFilePath.isEmpty()) {
//            throw new IllegalArgumentException("The file path cannot be empty");
//        } else {
//            String suffiex = getSuffiex(readFilePath);
//            if (suffiex.isEmpty()) {
//                throw new IllegalArgumentException("The file suffix cannot be empty");
//            }
//            if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)) {
//                try {
//                    is = new FileInputStream(readFilePath);
//                    readworkbook = WorkbookFactory.create(is);
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (EncryptedDocumentException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (InvalidFormatException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        if (is != null) {
//                            is.close();
//                        }
//                        if (readworkbook != null) {
//                            readworkbook.close();
//                        }
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            } else {
//                throw new IllegalArgumentException("This file is not an Excel");
//            }
//        }
//    }
//
//    /**
//     * Also read the contents of the specified Sheet.
//     * @param sheetNo The sheet number, starting at 0, is set to null if sheetNo reads the full text.
//     * @return excel content.
//     */
//    public static String readExcel(final Integer sheetNo) {
//        StringBuilder sb = new StringBuilder();
//        try {
//            getWorkbook(readFilePath);
//            if (readworkbook != null) {
//                if (sheetNo == null) {
//                    int numberOfSheets = readworkbook.getNumberOfSheets();
//                    for (int i = 0; i < numberOfSheets; i++) {
//                        Sheet sheet = readworkbook.getSheetAt(i);
//                        if (sheet == null) {
//                            continue;
//                        }
//                        sb.append(readExcelSheet(sheet));
//                    }
//                } else {
//                    Sheet sheet = readworkbook.getSheetAt(sheetNo);
//                    if (sheet != null) {
//                        sb.append(readExcelSheet(sheet));
//                    }
//                }
//            }
//        } catch (EncryptedDocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return sb.toString();
//    }
//
//    /**
//     * read Excel Sheet.
//     * @param sheet sheet
//     * @return String
//     */
//    public static String readExcelSheet(final Sheet sheet) {
//        StringBuilder sb = new StringBuilder();
//        if (sheet != null) {
//            int rowNos = sheet.getLastRowNum();// Get the total number of records in excel
//            for (int i = 0; i <= rowNos; i++) {
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    int columNos = row.getLastCellNum();
//                    for (int j = 0; j < columNos; j++) {
//                        Cell cell = row.getCell(j);
//                        if (cell != null) {
//                            cell.setCellType(CellType.STRING);
//                            sb.append(cell.getStringCellValue() + " ");
//                        }
//                    }
//                    sb.append("-\n");
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     * get suffix.
//     * @param path path.
//     * @return suffix
//     * 获取后缀名
//     */
//    private static String getSuffiex(final String path) {
//        if ( path.isEmpty()) {
//            return "";
//        }
//        int index =  path.lastIndexOf(".");
//        if (index == -1) {
//            return "";
//        }
//        return  path.substring(index + 1,  path.length());
//    }
//
//
//}