package com.xiaohe66.demo.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * @author xh
 * @date 2017-12-8
 */
public class PoiUtil {

    public static void read(String filePath) throws IOException, InvalidFormatException {
        if(filePath == null || filePath.length() == 0){
            throw new NullPointerException("filePath is empty");
        }
        Workbook workbook = WorkbookFactory.create(new File(filePath));
        Sheet sheet = workbook.getSheetAt(0);
        Row row = null;
        Cell cell = null;
        for (int i = 0,n=sheet.getPhysicalNumberOfRows(); i < n; i++) {
            row = sheet.getRow(i);
            for (int j = 0,m = row.getPhysicalNumberOfCells(); j < m; j++) {
                cell = row.getCell(j);
                String str = cell.getRichStringCellValue().getString();
                System.out.print(str +"\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        try {
            read("F:\\deprecated\\deprecated.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e){
            e.printStackTrace();
        }
    }

}
