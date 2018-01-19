package com.xiaohe66.demo.se.oop.perm.test2;

import com.xiaohe66.demo.se.oop.perm.test.PermTest;

/**
 * 在不同包下
 * package和protected访问权限对比
 *
 *
 * @author xh
 * @date 2017-12-17
 */
public class PermTestSon extends PermTest{

    public void sayA(){
        String a1 = null;
        //在不同包下的子类，可以访问protected权限
        //a1 = a;
        System.out.println("不同包下的子类访问protected:"+a1);
    }

    public void sayB(){
        String b1 = null;
        //在不同包下的子类，不可以访问package权限
        //b1 = b;
        System.out.println("不同包下的子类访问package:"+b1);
    }

    public static void main(String[] args) {
        PermTest test = new PermTestSon();

        //在不同包下和其它类，不可以访问protected权限
//        System.out.println("不同包下的其它类访问protected:"+test.a);
        //在不同包下和其它类，不可以访问package权限
//        System.out.println("不同包下的其它类访问package:"+test.b);

        PermTestSon permTestSon = new PermTestSon();
        permTestSon.sayA();
        permTestSon.sayB();
    }
}
