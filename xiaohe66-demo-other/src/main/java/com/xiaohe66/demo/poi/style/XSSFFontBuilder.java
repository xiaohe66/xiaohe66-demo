package com.xiaohe66.demo.poi.style;

import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;

/**
 * @author xiaohe
 * @time 2019.07.16 10:19
 */
public class XSSFFontBuilder {

    private final XSSFWorkbook workbook;

    private final XSSFFont font;

    public XSSFFontBuilder(XSSFWorkbook workbook) {
        this.workbook = workbook;
        font = workbook.createFont();
    }

    public XSSFFontBuilder color(int r, int g, int b) {
        font.setColor(newColor(r, g, b));
        return this;
    }

    public XSSFFontBuilder bold(boolean isBold){
        font.setBold(isBold);
        return this;
    }

    public XSSFFontBuilder font(String fontName){
        font.setFontName(fontName);
        return this;
    }

    public XSSFFontBuilder size(short size){
        font.setFontHeightInPoints(size);
        return this;
    }



    public XSSFFont build(){
        return font;
    }

    private XSSFColor newColor(int r, int g, int b) {
        return new XSSFColor(new Color(r, g, b));
    }
}
