package com.xiaohe66.demo.poi.creator;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

/**
 * 2007 Excel 表格创基类
 *
 * @author xiaohe
 * @time 2019.08.14 16:07
 */
public abstract class XSSFExcelCreator implements ExcelCreator<XSSFWorkbook, XSSFSheet, XSSFRow, XSSFCell, XSSFCellStyle> {

    private XSSFWorkbook workbook;

    public XSSFExcelCreator() {
        this.workbook = new XSSFWorkbook();
    }

    @Override
    public XSSFSheet getSheet(int index) {
        return workbook.getSheetAt(index);
    }

    @Override
    public XSSFSheet createSheet() {
        return workbook.createSheet();
    }

    @Override
    public XSSFSheet getOrCreateSheet(String name) {
        XSSFSheet sheet = workbook.getSheet(name);
        if (sheet == null) {
            sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName(name));
        }
        return sheet;
    }

    @Override
    public XSSFRow getOrCreateRow(XSSFSheet sheet, int index) {
        XSSFRow row = sheet.getRow(index);
        if (row == null) {
            row = sheet.createRow(index);
        }
        return row;
    }

    @Override
    public XSSFCell getOrCreateCell(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        if (cell == null) {
            cell = row.createCell(index);
        }
        return cell;
    }

    @Override
    public void setValue(XSSFCell cell, String value) {
        cell.setCellValue(value);
    }

    @Override
    public void setValue(XSSFCell cell, Float value) {
        cell.setCellValue(new BigDecimal(value.toString()).doubleValue());
    }

    @Override
    public void setValue(XSSFCell cell, double value) {
        cell.setCellValue(value);
    }

    @Override
    public void setValueAndStyle(XSSFCell cell, String value, XSSFCellStyle style) {
        cell.setCellValue(value);
        if (style != null) {
            cell.setCellStyle(style);
        }
    }

    @Override
    public void setValueAndStyle(XSSFCell cell, Float value, XSSFCellStyle style) {
        cell.setCellValue(new BigDecimal(value.toString()).doubleValue());
        if (style != null) {
            cell.setCellStyle(style);
        }
    }

    @Override
    public void setValueAndStyle(XSSFCell cell, double value, XSSFCellStyle style) {
        cell.setCellValue(value);
        if (style != null) {
            cell.setCellStyle(style);
        }
    }


    /**
     * 合并单元格，该方法要在创建单元格之前调用
     *
     * @param sheet       合并单元格所在的表
     * @param beginRows   开始行
     * @param endRows     结束行
     * @param beginColumn 开始列
     * @param endColumn   结束列
     */
    @Override
    public void mergeCell(XSSFSheet sheet, int beginRows, int endRows, int beginColumn, int endColumn) {
        sheet.addMergedRegion(new CellRangeAddress(beginRows, endRows, beginColumn, endColumn));
    }

    @Override
    public void writeToStream(OutputStream outputStream) {
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new ExcelCreatorException(e);
        }
    }

    @Override
    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    @Override
    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            throw new ExcelCreatorException(e);
        }
    }
}
