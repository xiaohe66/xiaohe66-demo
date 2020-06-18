package com.xiaohe66.demo.se.jvm.classloader;

import com.sun.crypto.provider.DESKeyFactory;

/**
 *
 * 类加载器分为
 * 1.引导类加载器(加载Object/String等关键类)
 * 2.扩展类加载器(加载扩展的类)
 * 3.应用程序加载器(加载用户的类)
 *
 * @author xiaohe
 * @time 2020.06.18 15:23
 */
public class JDKClassloaderDemo {


    public static void main(String[] args) {

        System.out.println(Object.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(JDKClassloaderDemo.class.getClassLoader());

    }

}
