package com.xiaohe66.demo.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xh
 * @date 2017-12-7
 */
public class RenameTest {

    //1.读xls
    //2.读文件夹
    //3.从文件中提取id
    //4.与xls中的匹配取出name
    //5.改名

    @Test
    public void test() throws Exception{
        List<String[]> list = readXls("s",1);

        File[] files = readF("f");

        for (File file : files) {
            try{
                String name = file.getName();
                int index = name.lastIndexOf(".");

            }catch (Exception e){

            }
        }
    }

    private File[] readF(String folderPath){
        if(folderPath == null || folderPath.length() == 0){
            throw new NullPointerException("folderPath is null");
        }

        File folder = new File(folderPath);

        if(!folder.isDirectory()){
            throw new RuntimeException("folderPath is not director");
        }

        return folder.listFiles();
    }

    private List<String[]> readXls(String xlsPath,int sheetIndex) throws IOException, InvalidFormatException {
        if(xlsPath == null || xlsPath.length()==0){
            throw new NullPointerException("xlsPath is null");
        }
//        int sum=0;
        Workbook workbook = WorkbookFactory.create(new File(xlsPath));
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = null;
        int rowNum = sheet.getPhysicalNumberOfRows();

        List<String[]> list = new ArrayList<String[]>(rowNum-1);
        for (int i = 1; i < rowNum; i++) {
            try{
                row = sheet.getRow(i);
                String id = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                list.add(new String[]{id,name});
            }catch (Exception e){
                System.out.println("读取出错:"+i);
            }
        }
        return list;
    }

}
