package com.xiaohe66.util.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 输出某个文件夹中所有文件的文件名
 *
 * @author xiaohe
 * @date 2019.03.13 11:51
 */
public class ShowFile {

    public static void main(String[] args) throws IOException {

        Path initPath = Paths.get("D:\\xiaohe66-log");

        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {

                System.out.println(file.getFileName().toString());

                return FileVisitResult.CONTINUE;
            }

        });
    }
}