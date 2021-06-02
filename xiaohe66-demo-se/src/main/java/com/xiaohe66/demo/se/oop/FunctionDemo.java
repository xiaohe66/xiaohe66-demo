package com.xiaohe66.demo.se.oop;

/**
 * @author xh
 * @date 2017-12-13
 *
 * 方法定义示例
 * 方法的重载,需要满足以下条件
 * 1、方法名相同
 * 2、参数数量不同（参数数量相同时，需要至少有一个参数的类型不同）
 */
public class FunctionDemo {

    /**
     * 定义一个方法print()，返回值为空
     * @param name
     *          定义类型为String的参数，参数名为name
     * @param age
     *          定义类型为int的参数，参数名为age
     */
    public void print(String name,int age){
        System.out.println(name+"今年"+age+"岁");
    }

    /**
     * 重载print方法
     * @param name
     *            定义类型为String的参数，参数名为name
     * @param age
     *            定义类型为short的参数，参数名为age
     *            因为这个参数的类型不一样，因此符合重载的规定
     */
    public void print(String name,short age){
        System.out.println(name+"今年"+age+"岁");
    }

    /**
     * 重载print方法
     * @param name
     * @param age
     * @param hobby
     *          定义一个String类型的可变参数，可变类型参数一个方法中只能定义一个
     */
    public void print(String name,int age,String... hobby){
        String str = name+"今年"+age+"岁，爱好是：";
        for (String s : hobby) {
            str += s+ "、";
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        FunctionDemo functionDemo = new FunctionDemo();
        functionDemo.print("小何",22);
        functionDemo.print("小何",22);
        functionDemo.print("小何",22,"下棋");
        //可变参数，
        functionDemo.print("小何",22,"下棋","K歌");
    }

}
