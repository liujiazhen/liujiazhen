package org.liujiazhen.poi.test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.apache.poi.xssf.usermodel.charts.XSSFLineChartData;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        extracted();
    }

    private static void extracted() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet dataSheet = wb.createSheet("linechart");

        final int NUM_OF_ROWS = 10;
        final int NUM_OF_COLUMNS = 4;

        Row row;
        Cell cell;
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
            row = dataSheet.createRow((short) rowIndex);
            for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                cell.setCellValue(rowIndex * ((colIndex + 1) + ((int) (Math.random() * 10))));
            }
        }

        Drawing drawing = dataSheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, NUM_OF_COLUMNS + 2, 3, NUM_OF_COLUMNS + 15, 20);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 0, 0));
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 1, 1));
        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 2, 2));
        ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 3, 3));

        LineChartSeries series1 = data.addSeries(xs, ys1);
        series1.setTitle("one");
        LineChartSeries series2 = data.addSeries(xs, ys2);
        series2.setTitle("two");
        LineChartSeries series3 = data.addSeries(xs, ys3);
        series3.setTitle("three");

        chart.plot(data, bottomAxis, leftAxis);

        XSSFChart xssfChart = (XSSFChart) chart;
        CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
        plotArea.getLineChartArray()[0].getSmooth();
        CTBoolean ctBool = CTBoolean.Factory.newInstance();
        ctBool.setVal(false);
        plotArea.getLineChartArray()[0].setSmooth(ctBool);
        for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
            ser.setSmooth(ctBool);
        }

        FileOutputStream fileOut = new FileOutputStream("D:/chart.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

    public static void test(XSSFSheet sheet) {

        Map<String, Object> params = new HashMap<String, Object>();

        // 图表位置（B36左上角：AA53左上角）
        int[] position = new int[]{
                getColumnIndexByAddress("B"), 35, getColumnIndexByAddress("AA"), 52};

        // x轴坐标区域（B60：B90）
        int[] xAxisRange = new int[]{
                59, 89, getColumnIndexByAddress("B"), getColumnIndexByAddress("B")};

        // 每个系列的数据（D60：D90、J60：J90、P60：P90）
        // 每个系列的标题（D59、J59、P59）
        List<Integer[]> seriesDataRangeList = new ArrayList<Integer[]>();
        seriesDataRangeList.add(new Integer[]{
                59, 89, getColumnIndexByAddress("D"), getColumnIndexByAddress("D"),
                58, getColumnIndexByAddress("D")});
        seriesDataRangeList.add(new Integer[]{
                59, 89, getColumnIndexByAddress("J"), getColumnIndexByAddress("J"),
                58, getColumnIndexByAddress("J")});
        seriesDataRangeList.add(new Integer[]{
                59, 89, getColumnIndexByAddress("P"), getColumnIndexByAddress("P"),
                58, getColumnIndexByAddress("P")});

        params.put("chartPosition", position);
        params.put("xAxisRange", xAxisRange);
        params.put("seriesDataRangeList ", seriesDataRangeList);

        createLineChart(sheet, params);
    }

    /**
     * create line chart
     *
     * @param sheet
     * @param params chartPosition            int[]{startRow, endRow, startCol, endCol}
     *               xAxisRange               int[]{startRow, endRow, startCol, endCol}
     *               seriesDataRangeList      List<Integer[]>{startRow, endRow, startCol, endCol, titleRow, titleCol}
     */
    private static void createLineChart(XSSFSheet sheet, Map<String, Object> params) {


        int[] position = (int[]) params.get("chartPosition");
        int[] xAxisRange = (int[]) params.get("xAxisRange");
        List<Integer[]> seriesDataRangeList = (List<Integer[]>) params.get("seriesDataRangeList ");

        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor =
                drawing.createAnchor(0, 0, 0, 0, position[0], position[1], position[2], position[3]);

        XSSFChart chart = drawing.createChart(anchor);
        XSSFChartLegend legned = chart.getOrCreateLegend();
        legned.setPosition(LegendPosition.TOP);

        // set blank values as gaps
        CTDispBlanksAs disp = CTDispBlanksAs.Factory.newInstance();
        disp.setVal(STDispBlanksAs.GAP);


        chart.getCTChart().setDispBlanksAs(disp);

        XSSFLineChartData chartData = chart.getChartDataFactory().createLineChartData();
        XSSFChartAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        XSSFChartAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
        bottomAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        bottomAxis.setNumberFormat("yyyy/m/d");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        leftAxis.setMinimum(0);

        // 设置x轴坐标区域（B60：B90）
        ChartDataSource<String> xAxisData =
                DataSources.fromStringCellRange(sheet,
                        new CellRangeAddress(xAxisRange[0], xAxisRange[1], xAxisRange[2], xAxisRange[3]));

        // 设置数据区域，即每个系列的数据（D60：D90、J60：J90、P60：P90）
        for (Integer[] seriesDataRange : seriesDataRangeList) {

            ChartDataSource<Number> yAxisData =
                    DataSources.fromNumericCellRange(sheet,
                            new CellRangeAddress(seriesDataRange[0], seriesDataRange[1], seriesDataRange[2], seriesDataRange[3]));
            LineChartSeries series = chartData.addSeries(xAxisData, yAxisData);

            // 设置每个系列的标题（D59、J59、P59）
            series.setTitle(sheet.getRow(seriesDataRange[4]).getCell(seriesDataRange[5]).getStringCellValue());
        }

        chart.plot(chartData, bottomAxis, leftAxis);

        // unsmooth series(好像必须写在polt方法之后)
        CTPlotArea plotArea = chart.getCTChart().getPlotArea();
        for (CTLineChart ch : plotArea.getLineChartList()) {

            for (CTLineSer ser : ch.getSerList()) {

                CTBoolean ctBool = CTBoolean.Factory.newInstance();
                ctBool.setVal(false);
                ser.setSmooth(ctBool);
            }
        }
    }

    /**
     * get column index by column address
     */
    public static int getColumnIndexByAddress(String columnAddress) {

        int colNum = 0;

        for (int i = 0; i < columnAddress.length(); i++) {

            char ch = columnAddress.charAt(columnAddress.length() - 1 - i);
            colNum += (ch - 'A' + 1) * Math.pow(26, i);
        }

        return colNum - 1;
    }
}