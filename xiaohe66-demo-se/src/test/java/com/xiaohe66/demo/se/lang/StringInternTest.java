package com.xiaohe66.demo.se.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaohe
 * @time 2021.06.04 11:15
 */
public class StringInternTest {

    List<String> list = new ArrayList<>();

    /**
     * JVM参数：
     * -XX:+PrintGCDetails -Xms200M -Xmx200M
     * <p>
     * 说明：
     * String#new 会在堆中创建一个对象。而String#intern 会返回常量池的引用。
     */
    @Test
    public void test() {

        byte[] bytes = new byte[1024 * 1024];
        for (; ; ) {
            // 将String添加到 list中，很快OOM
            //String str = new String(bytes);

            // 调用String#intern后再添加到list中，有很多yong gc，但不会OOM。这里验证了String#intern会返回常量池的引用
            // 若想验证是否为相同对象，可对 list 中不同下标的 String进行 == 比较，即可得出结果
            String str = new String(bytes).intern();

            list.add(str);
        }
    }

}
