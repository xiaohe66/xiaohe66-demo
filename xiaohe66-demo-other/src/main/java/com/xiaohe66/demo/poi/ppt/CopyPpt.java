package com.xiaohe66.demo.poi.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 复制每一页幻灯片
 * <p>
 * 目前已知不支持的情况：
 * 1.不支持 SmartArt 图表
 *
 * @author xiaohe
 * @time 2021.06.10 13:52
 */
public class CopyPpt {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\xiaohe66\\template.pptx");
        File newFile = new File("D:\\xiaohe66\\copy.pptx");

        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(newFile);
             XMLSlideShow ppt = new XMLSlideShow(inputStream)) {

            // new List原因 : 在遍历对页的操作会影响原有的 list 结构, 从而导致 ConcurrentModificationException
            List<XSLFSlide> slideList = new ArrayList<>(ppt.getSlides());

            int index = 1;
            for (XSLFSlide slide : slideList) {

                XSLFSlide newSlide = ppt.createSlide(slide.getSlideLayout());
                newSlide.importContent(slide);

                ppt.setSlideOrder(newSlide, index);
                index += 2;
            }

            ppt.write(outputStream);
        }


    }
}
