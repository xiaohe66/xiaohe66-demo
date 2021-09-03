package com.xiaohe66.demo.se.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 研究GC过程使用，该程序一直运行下去，会出现OOM
 *
 * <p> 打开 VisualVM 中的插件 Visual GC 可以查看GC的过程
 *
 * <p> Visual GC 插件需要安装
 * 在 工具-插件设置-编辑里面，填入从 VisualVM 官网的插件中得到的url（在Plugins Centers中），即可安装
 * 这里提供一个（不确定未来是否可用）：https://visualvm.github.io/archive/uc/8u40/updates.html
 * <p>
 * // -Xms200M -Xmx200M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\\jvm.dump
 *
 * @author xiaohe
 * @time 2020.06.23 09:58
 */
public class OOMDemo {

    byte[] b = new byte[1024 * 1024];

    public static void main(String[] args) throws InterruptedException {

        List<OOMDemo> list = new ArrayList<>();

        int i = 0;
        while (true) {
            OOMDemo demo = new OOMDemo();
            if (i++ % 5 > 0) {
                list.add(demo);
            }
            // 调节该处的休眠时间以控制出现OOM的速度
            Thread.sleep(1000);
        }
    }
}
