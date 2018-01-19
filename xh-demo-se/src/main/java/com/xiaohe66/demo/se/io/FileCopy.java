package com.xiaohe66.demo.se.io;

import java.io.*;

/**
 * @author xh
 * @date 18-1-5 005
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //数据源
        File srcfile = new File("数据源");
        //目的地
        File destfile = new File("目的地");
        //methd1(srcfile,destfile);
        //methd2(srcfile,destfile);
        //methd3(srcfile,destfile);
        //methd4(srcfile,destfile);
        methd5(srcfile, destfile);
    }

    /**
     * 方式四：使用缓冲字符流一次读取一个字符数组
     */
    private static void methd4(File srcfile, File destfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destfile));
        char[] ch = new char[1024];
        int length = 0;
        while ((length = br.read(ch)) != -1) {
            bw.write(ch, 0, length);
        }
        bw.close();
        br.close();

    }

    /**
     * 方式三：使用缓冲字符流一次读取一个字符
     */
    private static void methd3(File srcfile, File destfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destfile));
        int ch = 0;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }
        bw.close();
        br.close();

    }

    /**
     * 方式二：基本字符流一次读写一个字符数组
     */
    private static void methd2(File srcfile, File destfile) throws IOException {
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(destfile);
        char[] ch = new char[1024];
        int length = 0;
        while ((length = fr.read(ch)) != -1) {
            fw.write(ch, 0, length);
        }
        //关闭资源，先开后关原则
        fw.close();
        fr.close();

    }

    /**
     * 方式一：基本字符流一次读写一个字符
     */
    private static void methd1(File srcfile, File destfile) throws IOException {
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(destfile);
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fw.close();
        fr.close();

    }

    /**
     * 方式五：使用缓冲字符流一次读取一个字符串
     */
    private static void methd5(File srcfile, File destfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destfile));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();

    }
}
