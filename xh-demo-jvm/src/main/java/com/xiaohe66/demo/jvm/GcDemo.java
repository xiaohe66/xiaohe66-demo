package com.xiaohe66.demo.jvm;

/**
 * -XX:+PrintGCDetails -Xms256M -Xmx256M -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=256M
 *
 * @author xiaohe
 * @time 2020.11.02 10:48
 */
public class GcDemo {

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        
        allocation1 = new byte[60000 * 1024];
        allocation2 = new byte[8000 * 1024];
        allocation3 = new byte[1000 * 1024];
        allocation4 = new byte[1000 * 1024];
        allocation5 = new byte[1000 * 1024];
        allocation6 = new byte[1000 * 1024];

    }

}
