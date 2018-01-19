package com.xiaohe66.demo.se.base;

/**
 * @author xh
 * @date 2017-12-9
 *
 * 运算符
 */
public class Operator {

    /**
     * 基础运算符
     */
    public static void base(){
        int a1 = 1+2;
        int a2 = 3-1;
        int a3 = 2*3;
        int a4 = 4/2;
        //取余运算，
        int a5 = 10%3;
        System.out.println("1+2="+a1);
        System.out.println("3-1="+a2);
        System.out.println("2*3="+a3);
        System.out.println("4/2="+a4);
        System.out.println("10%3="+a5);
    }

    /**
     * 自增自减运算符
     * ---------------------
     * |  i++  |  先用后加  |
     * ---------------------
     * |  ++i  |  先加后用  |
     * ---------------------
     * |  i--  |  先用后减  |
     * ---------------------
     * |  --i  |  先减后用  |
     * ---------------------
     */
    public static void base2(){
        int a1 = 1;
        int a2 = a1++;
        System.out.println("a2="+a2);
        int b1 = 1;
        int b2 = --b1;
        System.out.println("b2="+b2);
    }

    /**
     * 逻辑运算符
     * &&:与，在表达式2边都为true时，结果才为true
     * ||:或，在表达式2边至少有一个为true时，结果就为true
     * &：不短路与，同“&&”
     * |：不短路或，同“||”
     * ^：异或，表达式2边结果不相同时，结果为true，否则结果为false
     *
     * 单字符的短语逻辑运算符和双字符短语逻辑运算符有以下区别
     * 短路：在表达式1能确定最终结果时，不判断表达式2
     * 不短路：2边的表达式都要判断
     */
    public static void logic(){

        //有1边不为true，结果为false
        boolean b1 = true && false;
        System.out.println("b1="+b1);

        //至少有1个true，结果为true
        boolean b2 = true || false;
        System.out.println("b2="+b2);

        //表达式2边结果不相同，结果为true
        boolean b3 = true ^ false;
        System.out.println("b3="+b3);

        //短路与，因为表达式1为false，因此不会判断表达式2，所以表达式2不会执行，i的值为0
        int i=0;
        boolean b4 = false && 0 == i++;
        System.out.println("b4="+b4+",i="+i);

        //不短路与，表达式2边都要判断，因此表达式式会执行，j的值为1
        int j=0;
        boolean b5 = false & 0 == j++;
        System.out.println("b5="+b5+",j="+j);
    }


    public static void main(String[] args) {
        base();
        base2();
        logic();
    }
}
