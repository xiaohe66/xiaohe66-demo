package com.xiaohe66.demo.poi.ppt;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohe
 * @time 2021.06.09 16:26
 */
public class ReplaceImagePpt {

    public static void main(String[] args) throws IOException {

        File[] imageFileArr = new File[]{
                new File("D:\\xiaohe66\\1.png"),
                new File("D:\\xiaohe66\\2.png"),
                new File("D:\\xiaohe66\\3.png")};

        File file = new File("D:\\xiaohe66\\read_shape.pptx");
        File newFile = new File("D:\\xiaohe66\\new.pptx");

        try (FileInputStream fileOutputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(newFile);
             XMLSlideShow ppt = new XMLSlideShow(fileOutputStream)) {

            XSLFSlide slide = ppt.getSlides().get(0);

            // note : 在对幻灯片操作时，get到的集合会变，因此需要保存下来
            List<XSLFShape> shapeList = new ArrayList<>(slide.getShapes());

            for (int i = 0; i < shapeList.size(); i++) {

                XSLFShape shape = shapeList.get(i);

                // 在 ppt 创建一个图片。但这个图片还未被使用
                XSLFPictureData pictureData = ppt.addPicture(imageFileArr[i], PictureData.PictureType.PNG);

                // 将图片加入到指定页中
                XSLFPictureShape picture = slide.createPicture(pictureData);

                // 设置图片的位置、宽高
                picture.setAnchor(shape.getAnchor());

                // 移除掉占位用的形状
                slide.removeShape(shape);

            }

            ppt.write(outputStream);
        }

    }

}
