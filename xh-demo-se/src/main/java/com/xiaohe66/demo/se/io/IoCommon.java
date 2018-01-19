package com.xiaohe66.demo.se.io;

import java.io.File;
import java.io.IOException;

/**
 * @author xh
 * @date 18-1-5 005
 */
public class IoCommon {

    public static void main(String[] args) {
        File file = new File("D://java创建的目录");

        System.out.println("文件或目录是否存在:"+file.exists());

        //创建目录,返回一个布尔值，true表示创建成功，false表示创建失败
        System.out.println("创建目录的返回值："+file.mkdir());

        System.out.println("文件或目录是否存在:"+file.exists());

        File file2 = new File("D://java创建的目录//java创建的文件.txt");

        System.out.println("文件或目录是否存在:"+file2.exists());
        //创建文件，需要捕获异常
        try {
            System.out.println("创建文件的返回值："+file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件或目录是否存在:"+file2.exists());

        System.out.println("删除文件是否成功:"+file2.delete());

        //删除文件夹，必须保证文件夹为空
        System.out.println("删除文件是否成功:"+file.delete());
    }
}
