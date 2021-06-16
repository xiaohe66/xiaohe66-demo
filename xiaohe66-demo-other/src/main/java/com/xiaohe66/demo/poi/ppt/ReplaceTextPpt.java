package com.xiaohe66.demo.poi.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiaohe
 * @time 2021.06.11 18:01
 */
public class ReplaceTextPpt {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\xiaohe66\\template.pptx");
        File newFile = new File("D:\\xiaohe66\\new.pptx");

        try (FileInputStream fileOutputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(newFile);
             XMLSlideShow ppt = new XMLSlideShow(fileOutputStream)) {

            XSLFSlide slide = ppt.getSlides().get(0);

            XSLFTextShape[] textShapes = slide.getPlaceholders();

            for (XSLFTextShape textShape : textShapes) {

                XSLFTextBox textBox = slide.createTextBox();
                textBox.setAnchor(textShape.getAnchor());
                textBox.setText("替换");

                slide.removeShape(textShape);
            }

            ppt.write(outputStream);
        }

    }

}
