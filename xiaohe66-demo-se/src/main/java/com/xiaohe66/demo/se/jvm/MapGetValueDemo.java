package com.xiaohe66.demo.se.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用 HashMap 进行字符转换问题
 *
 * <p>
 * -Xmx20m -Xms20m -XX:+PrintGCDetails  -XX:+PrintGC
 *
 * @author xiaohe
 * @time 2020.11.02 16:25
 */
public class MapGetValueDemo {


    public String val(String key) {

        Map<String, String> map = new HashMap<>();

        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");
        map.put("D", "d");
        map.put("E", "e");
        map.put("F", "f");
        map.put("G", "g");

        return map.get(key);
    }

    public String val2(String key) {

        switch (key) {
            case "A":
                return "a";
            case "B":
                return "b";
            case "C":
                return "c";
            case "D":
                return "d";
            case "E":
                return "e";
            case "F":
                return "f";
            case "G":
                return "g";
            default:
                return null;
        }
    }


    public static void main(String[] args) {

        MapGetValueDemo demo = new MapGetValueDemo();

        String[] keys = new String[]{"A", "B", "C", "D", "E", "F", "G"};

        // 1. 设置次数为 1000，可见 map 的方式，比 switch 新增了非常多的无用内存
        // 2. 设置次数为 10000后，可见 map 的方法触发了多少gc，而 switch 方式，无gc
        for (int i = 0; i < 10000; i++) {
            for (String key : keys) {
                //demo.val(key);
                demo.val2(key);
            }
        }

    }


}
