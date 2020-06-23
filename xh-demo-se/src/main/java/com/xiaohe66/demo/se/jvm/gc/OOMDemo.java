package com.xiaohe66.demo.se.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 研究GC过程使用，该程序一直运行下去，会出现OOM
 *
 * <p> 打开 VisualVM 中的插件 Visual GC 可以查看GC的过程
 *
 * @author xiaohe
 * @time 2020.06.23 09:58
 */
public class OOMDemo {

    byte[] b = new byte[1024 * 1024];

    public static void main(String[] args) throws InterruptedException {

        List<OOMDemo> list = new ArrayList<>();

        while (true) {
            list.add(new OOMDemo());
            // 调节该处的休眠时间以控制出现OOM的速度
            Thread.sleep(100);
        }
    }
}
