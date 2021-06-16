package com.xiaohe66.demo.poi.ppt;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 创建一个ppt，放一张图片进去
 *
 * @author xiaohe
 * @time 2021.06.09 16:18
 */
public class HelloPpt {

    public static void main(String[] args) throws IOException {

        File pptFile = new File("D:\\xiaohe66\\hello.pptx");
        File imageFile = new File("D:\\xiaohe66\\test.png");

        try (FileOutputStream fileOutputStream = new FileOutputStream(pptFile);
             XMLSlideShow ppt = new XMLSlideShow()) {

            // 一个 XSLFSlide 表示一页
            XSLFSlide slide = ppt.createSlide();

            XSLFPictureData pictureData = ppt.addPicture(imageFile, PictureData.PictureType.PNG);
            slide.createPicture(pictureData);

            ppt.write(fileOutputStream);

        }

    }

}
