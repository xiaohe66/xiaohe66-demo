package com.xiaohe66.demo.poi.creator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Closeable;
import java.io.OutputStream;

/**
 * @author xiaohe
 * @time 2019.07.15 17:37
 */
public interface ExcelCreator<W extends Workbook, S extends Sheet, R extends Row, C extends Cell, T extends CellStyle> extends Closeable {

    S getSheet(int index);

    S createSheet();

    S getOrCreateSheet(String name);

    R getOrCreateRow(S sheet, int index);

    C getOrCreateCell(R row, int index);

    void setValue(C cell, String value);

    void setValue(C cell, Float value);

    void setValue(C cell, double value);

    void setValueAndStyle(C cell, String value, T style);

    void setValueAndStyle(C cell, Float value, T style);

    void setValueAndStyle(C cell, double value, T style);

    void mergeCell(S sheet, int beginRows, int endRows, int beginColumn, int endColumn);

    W getWorkbook();

    void writeToStream(OutputStream outputStream);
}
