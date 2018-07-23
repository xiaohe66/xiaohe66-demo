package com.xiaohe66.demo.spring.aop.changretval.test;

/**
 * 切面改变返回值，主类
 *
 * @author xh
 * @version 1.0
 * @date 2018-05-30 09:52
 *
 * @see ChangReturnValueAsp
 */
public class ChangReturnValMain {

    public String doTask(String val){
        System.out.println("val="+val);
        return val;
    }

    public Object doTask2(String val){
        System.out.println("val="+val);
        return val;
    }

    public Object doTask3(){
        throw new NullPointerException("hello");
    }

}
