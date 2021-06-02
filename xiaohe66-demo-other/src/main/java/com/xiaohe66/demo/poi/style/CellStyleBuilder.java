package com.xiaohe66.demo.poi.style;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @author xiaohe
 * @time 2019.08.16 10:09
 */
public interface CellStyleBuilder<T extends CellStyle, B extends CellStyleBuilder> {

    B backgroundColor(int r, int g, int b);

    B font(Font font);

    B alignment(VerticalAlignment alignment);

    B alignment(HorizontalAlignment alignment);

    B border(int r, int g, int b);

    B dataFormat(String pattern);

    T build();
}
