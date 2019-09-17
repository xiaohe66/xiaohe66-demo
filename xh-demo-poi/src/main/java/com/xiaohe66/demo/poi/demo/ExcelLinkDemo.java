package com.xiaohe66.demo.poi.demo;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 给Excel中的一个单元格设置超链接
 *
 * @author xiaohe
 * @time 2019.09.17 18:24
 */
public class ExcelLinkDemo {

    void test() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCell cell = workbook.createSheet().createRow(0).createCell(0);

        XSSFFont font = workbook.createFont();
        // 字体蓝色
        font.setColor(IndexedColors.BLUE.index);
        // 字体下划线
        font.setUnderline(XSSFFont.U_SINGLE);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);

        XSSFCreationHelper xssfCreationHelper = new XSSFCreationHelper(workbook);
        XSSFHyperlink hyperlink = xssfCreationHelper.createHyperlink(HyperlinkType.URL);

        // 设置超链接地址
        hyperlink.setAddress("http://www.baidu.com");

        cell.setHyperlink(hyperlink);
        cell.setCellValue("http://www.baidu.com");
        cell.setCellStyle(style);

        // 写到磁盘中
        File file = Files.createTempFile("test", ".xlsx").toFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);

        // 调用windows程序打开这个excel文件
        Desktop.getDesktop().open(file);
    }

    public static void main(String[] args) throws IOException {
        new ExcelLinkDemo().test();
    }

}
