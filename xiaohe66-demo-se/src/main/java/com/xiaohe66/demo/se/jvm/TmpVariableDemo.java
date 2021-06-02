package com.xiaohe66.demo.se.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大量中间变量造成 OOM 问题
 *
 * <p>
 * -Xmx64m -Xms64m -XX:+PrintGCDetails -XX:+PrintGC
 *
 * @author xiaohe
 * @time 2020.11.02 17:16
 */
public class TmpVariableDemo {

    private void out(List<String[]> data) {
        System.out.println("输出：共" + data.size() + "条数据");
    }

    private void out(String[] data) {

    }

    private List<Map<String, Object>> queryData() {

        List<Map<String, Object>> list = new ArrayList<>();
        int n = 30000;
        int m = 10;

        for (int i = 0; i < n; i++) {

            Map<String, Object> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                map.put("key_" + i + "_" + j, "val_" + i + "_" + j);
            }
            list.add(map);
        }

        return list;
    }

    private void test1() {

        List<Map<String, Object>> dataList = queryData();

        List<String[]> list = new ArrayList<>();

        for (Map<String, Object> map : dataList) {

            String[] arr = new String[map.size()];
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {

                // OOm, 改成 String.valueOf 后不再 OOM
                //arr[i++] = entry.getValue() + "";
                arr[i++] = String.valueOf(entry.getValue());
            }

            list.add(arr);
        }

        out(list);
    }

    private void test2() {
        List<Map<String, Object>> dataList = queryData();

        for (Map<String, Object> map : dataList) {

            String[] arr = new String[map.size()];
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {

                // OOm
                arr[i++] = entry.getValue() + "";
                // 改成 String.valueOf 后不再 OOM
                //arr[i++] = String.valueOf(entry.getValue());
            }

            out(arr);
        }

    }

    public static void main(String[] args) throws InterruptedException {


        TmpVariableDemo demo = new TmpVariableDemo();

        demo.test1();
        //demo.test2();

    }


}
