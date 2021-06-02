package com.xiaohe66.demo.util.file;

import java.io.File;

/**
 * 文件删除
 *
 * @author xh
 * @version 1.0
 * @time 2018-08-22 09:45
 */
public class DeleteFile {

    private static void delAll(File parent){
        if(parent == null){
            return;
        }
        if(parent.isDirectory()){
            File[] files = parent.listFiles();
            if(files != null){
                for (File file : files) {
                    delAll(file);
                }
            }
        }
        parent.delete();
    }

    public static void delDirectoryWithName(String path,String name,boolean isDelete){
        delDirectoryWithName(new File(path),name,isDelete);
    }

    public static void delDirectoryWithName(File parent,String name,boolean isDelete){
        if(parent == null){
            return;
        }
        if(parent.isDirectory()){
            if (parent.getName().contains(name)) {
                System.out.println(parent.getPath());
                if(isDelete){
                    delAll(parent);
                }
            }else{
                File[] files = parent.listFiles();
                if(files != null){
                    for (File file : files) {
                        delDirectoryWithName(file,name,isDelete);
                    }
                }
            }
        }
    }

    public static void delFileWithName(String path,String name,boolean isDelete){
        delFileWithName(new File(path),name,isDelete);
    }

    public static void delFileWithName(File parent,String name,boolean isDelete){
        if(parent == null){
            return;
        }
        if(parent.isDirectory()){
            File[] files = parent.listFiles();
            if(files != null){
                for (File file : files) {
                    delFileWithName(file,name,isDelete);
                }
            }
        }else{
            if (parent.getName().contains(name)) {
                System.out.println(parent.getPath());
                if(isDelete){
                    parent.delete();
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = "???";
        DeleteFile.delFileWithName(path,".iml",true);
    }
}
