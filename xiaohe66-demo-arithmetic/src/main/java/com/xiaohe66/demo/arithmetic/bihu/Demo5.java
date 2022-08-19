package com.xiaohe66.demo.arithmetic.bihu;

/**
 * 打印一个菱形, 最外一层是*, 其他位置都是#
 *
 * @author xh
 * @date 17-12-24 024
 */
public class Demo5 {

    /**
     * 输出一行
     * @param i 第几行
     * @param n 半径
     */
    static void print(int i,int n){
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //计算空格数量，并加到字符串变量中
        for(int j=1;j<=n-i;j++){
            stringBuilder.append(" ");
        }
        //加入外层*号
        stringBuilder.append("* ");
        //加入内层#号
        for(int j=2;j<=i-1;j++){
            stringBuilder.append("# ");
        }
        //加入外层*号
        stringBuilder.append("*");
        //打印输出
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        int n = 7;

        //1.计算第1行和最后1行的输出格式
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            stringBuilder.append(" ");
        }
        //2.输出第1行
        stringBuilder.append("*");
        System.out.println(stringBuilder);
        //3.输出前一半行数，包括中间行
        for (int i = 3; i <= n ; i++) {
            print(i,n);
        }
        //4.输出后一半行数
        for (int i = n-1; i > 2 ; i--) {
            print(i,n);
        }
        System.out.println(stringBuilder);
    }
}
