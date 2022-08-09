package com.xiaohe66.demo.se.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化
 * 日期表达式：
     字母  日期或时间元素  表示  示例
     G  Era 标志符  Text  AD
     y  年  Year  1996; 96
     M  年中的月份  Month  July; Jul; 07
     w  年中的周数  Number  27
     W  月份中的周数  Number  2
     D  年中的天数  Number  189
     d  月份中的天数  Number  10
     F  月份中的星期  Number  2
     E  星期中的天数  Text  Tuesday; Tue
     a  Am/pm 标记  Text  PM
     H  一天中的小时数（0-23）  Number  0
     k  一天中的小时数（1-24）  Number  24
     K  am/pm 中的小时数（0-11）  Number  0
     h  am/pm 中的小时数（1-12）  Number  12
     m  小时中的分钟数  Number  30
     s  分钟中的秒数  Number  55
     S  毫秒数  Number  978
     z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00
     Z  时区  RFC 822 time zone  -0800
 *
 * @author xh
 * @date 2017-12-20
 */
public class DateFormatDemo {

    String dateFormat(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static void main(String[] args) {
        Date date = new Date();
        DateFormatDemo dateFormatDemo = new DateFormatDemo();
        System.out.println(dateFormatDemo.dateFormat(date,"yyyy-MM-dd"));
        System.out.println(dateFormatDemo.dateFormat(date,"yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateFormatDemo.dateFormat(date,"yyyy年MM月dd日 HH时mm分ss秒"));

    }
}
