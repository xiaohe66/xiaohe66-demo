package com.xiaohe66.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author xiaohe
 * @date 17-08-06 006
 *
 * 网站相关操作
 */
public class WebPageUtil {

    /**
     * 网页代码主读取
     * @param path
     *          网址
     * @return
     *          整个网页的html代码
     * @throws IOException
     *          io异常
     */
    public static String read(String path) throws IOException {
        //创建url
        URL url = new URL(path);
        //获取输入流
        InputStream is = url.openStream();
        //转换成字符流
        InputStreamReader isr = new InputStreamReader(is);
        //缓冲
        BufferedReader br = new BufferedReader(isr);

        StringBuilder result = new StringBuilder();
        String str = null;
        //逐行读取
        while ((str = br.readLine())!=null){
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args){
        try {
            String result = WebPageUtil.read("http://www.baidu.com");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
