package com.xiaohe66.demo.se.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author xiaohe
 * @time 2020.06.18 15:21
 */
public class MyClassloaderDemo {

    private static void test(String classPath) throws Exception{

        MyClassloader myClassloader = new MyClassloader(classPath);

        /*
         * 使用哪个加载器视当前项目中是否存在User类情况而定，可以注释User类来判断
         * 1.如果在当前项目中存在 User 类，则会用 App加载器加载
         * 2.如果在当前项目中不存在User类，则会用 MyClassloader加载器加载
         */
        Class<?> userClass = myClassloader.loadClass("com.xiaohe66.demo.se.jvm.classloader.User");

        Object user = userClass.newInstance();

        Method outMethod = userClass.getDeclaredMethod("out");

        outMethod.invoke(user, null);
    }

    public static void main(String[] args) throws Exception {

        test("C:/xiaohe66/test1");
        test("C:/xiaohe66/test2");


    }

}
