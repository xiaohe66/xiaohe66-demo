package com.xiaohe66.demo.se.date;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期、时间处理类
 *
 * @author xiaohe
 * @date 17-2-10 010
 */
public class CalendarDemo {

    /**
     * Calendar 的各种初始化方法
     *
     * @return 以当前时间初始化的Calendar实例
     */
    public static Calendar getCalendarInstance(){
        long timeStamp = System.currentTimeMillis();
        System.out.println("当前时间戳="+timeStamp);

        //获得一个Calender对象，已使用当前时间进行了初始化
        Calendar calendar = Calendar.getInstance();

        //使用时间戳以Calendar进行初始化
        calendar.setTimeInMillis(timeStamp);

        //使用Date初始化Calendar进行初始化
        Date date = new Date();
        date.setTime(timeStamp);
        calendar.setTime(date);

        return calendar;
    }

    /**
     * 日期和时间的输出
     */
    public void outTest(){
        Calendar calendar = CalendarDemo.getCalendarInstance();
        System.out.println("年="+calendar.get(Calendar.YEAR));
        System.out.println("今年第几月="+(calendar.get(Calendar.MONTH)+1));
        System.out.println("本月第几天="+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("今年第几天="+calendar.get(Calendar.DAY_OF_YEAR));
        //默认星期天是第1天
        System.out.println("这个星期第几天="+calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("本月最小天="+calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("本月最小天="+calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("时="+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分="+calendar.get(Calendar.MINUTE));
        System.out.println("秒="+calendar.get(Calendar.SECOND));
    }

    public static void main(String[] args) {
        new CalendarDemo().outTest();
    }
}
