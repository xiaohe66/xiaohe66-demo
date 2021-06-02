package com.xiaohe66.demo.boot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *
 * @author xh
 * @date 18-12-12 012
 */
@Component
public class TestTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void task(){
        System.out.println("现在的时间是："+DATE_FORMAT.format(new Date()));
    }

}
