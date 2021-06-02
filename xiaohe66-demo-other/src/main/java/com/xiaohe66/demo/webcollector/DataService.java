package com.xiaohe66.demo.webcollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author xh
 * @date 18-04-02 002
 */
public class DataService {


    private static final String URL = "";
    private static final String PORT = "";
    private static final String NAME = "";
    private static final String PWD = "";

    private static final String ROOT = "D:\\webcollector";

    private static int NUM = 0;

    public DataService(){
        File file = new File(ROOT);
        for (File file1 : file.listFiles()) {
            file1.delete();
        }
    }

    public File createFile(){
        synchronized (DataService.class){
            NUM++;
        }
        File file =  new File(ROOT+"\\"+NUM+".txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    public void execute(String url,String title,String content,String date){
        File file = createFile();
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream);
            printStream.println(url+"\r\n"+title+"\r\n"+date+"\r\n");
            printStream.append(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
