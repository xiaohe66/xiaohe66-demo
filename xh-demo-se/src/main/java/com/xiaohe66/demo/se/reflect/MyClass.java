package com.xiaohe66.demo.se.reflect;

/**
 * @author xh
 * @date 17-12-20 020
 */
public class MyClass {

    private String prop1 = "prop1默认值";
    protected String prop2 = "prop2默认值";
    String prop3 = "prop3默认值";
    public String prop4 = "prop4默认值";

    public void say(){
        System.out.println("prop1的值为："+prop1);
        System.out.println("prop2的值为："+prop2);
        System.out.println("prop3的值为："+prop3);
        System.out.println("prop4的值为："+prop4);
    }

    private void func1(){
        System.out.println("方法1");
    }

    protected int func2(int i){
        System.out.println("方法2");
        return i;
    }

    long func3(long a,long b){
        System.out.println("方法3");
        return a>b?a:b;
    }

    public void func4(){
        System.out.println("方法4");
    }
}
