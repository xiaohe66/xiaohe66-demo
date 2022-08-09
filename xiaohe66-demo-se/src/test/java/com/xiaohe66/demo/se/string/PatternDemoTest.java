package com.xiaohe66.demo.se.string;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DisplayName("正则")
class PatternDemoTest {

    private static final Pattern pattern = Pattern.compile("-");

    @DisplayName("正则匹配替换字符串")
    @Test
    void test1() {

        Matcher matcher = pattern.matcher("1-2-3-4-5-6-7");

        StringBuffer ret = new StringBuffer();

        while (matcher.find()) {
            // 这个方法只能接收 StringBuffer 参数
            matcher.appendReplacement(ret, "+");
        }

        System.out.println("未添加结尾： " + ret);

        // 这个方法必须得调用，否则就会缺少后面的
        matcher.appendTail(ret);

        System.out.println("已添加结尾： " + ret);
    }
}
