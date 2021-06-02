package com.xiaohe66.demo.webcollector;

import com.xiaohe66.demo.webcollector.DataService;
import com.xiaohe66.demo.webcollector.MyWebCollector;
import org.junit.Test;

/**
 * @author xh
 * @date 18-04-02 002
 */
public class WebCollectorTest {

    @Test
    public void test1() throws Exception {
        //depth-->深度
        new MyWebCollector("crawl", false).start(2);
    }

}
