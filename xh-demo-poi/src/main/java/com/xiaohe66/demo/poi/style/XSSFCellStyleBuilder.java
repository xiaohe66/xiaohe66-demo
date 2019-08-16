package com.xiaohe66.demo.poi.style;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;

/**
 * @author xiaohe
 * @time 2019.07.16 10:17
 */
public class XSSFCellStyleBuilder {

    private final XSSFWorkbook workbook;
    private final XSSFCellStyle style;

    public XSSFCellStyleBuilder(XSSFWorkbook workbook) {
        this.workbook = workbook;
        style = workbook.createCellStyle();
    }

    public XSSFCellStyleBuilder backgroundColor(int r, int g, int b) {
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(newColor(r, g, b));
        return this;
    }

    public XSSFCellStyleBuilder font(Font font) {
        style.setFont(font);
        return this;
    }

    public XSSFCellStyleBuilder alignment(VerticalAlignment alignment) {
        style.setVerticalAlignment(alignment);
        return this;
    }

    public XSSFCellStyleBuilder alignment(HorizontalAlignment alignment) {
        style.setAlignment(alignment);
        return this;
    }

    public XSSFCellStyleBuilder border(int r, int g, int b) {
        XSSFColor color = newColor(r, g, b);

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);

        style.setTopBorderColor(color);
        style.setRightBorderColor(color);
        style.setBottomBorderColor(color);
        style.setLeftBorderColor(color);
        return this;
    }

    public XSSFCellStyleBuilder percent(String pattern) {
        style.setDataFormat(workbook.createDataFormat().getFormat(pattern));
        return this;
    }

    public XSSFCellStyle build() {
        return style;
    }

    private XSSFColor newColor(int r, int g, int b) {
        return new XSSFColor(new Color(r, g, b));
    }

}
