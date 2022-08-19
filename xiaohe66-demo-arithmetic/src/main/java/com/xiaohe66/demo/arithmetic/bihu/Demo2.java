package com.xiaohe66.demo.arithmetic.bihu;

/**
 * 打印1, 0, 2, 4 这4个数字能组成的所有不重复的数
 *
 * @author xh
 * @date 17-12-31 024
 */
public class Demo2 {

    public static void main(String[] args) {
        //定义数组，用于遍历
        char[] arr = new char[]{'1','0','2','4'};
        //遍历千位
        for (char c : arr) {
            //遍历百位
            for (char c2 : arr) {
                //如果千位和百位相同，跳出
                if(c == c2){
                    continue;
                }
                //遍历十位
                for (char c3 : arr) {
                    //如果十位和百位或千位数字相同，跳出
                    if(c == c3 || c2 == c3){
                        continue;
                    }
                    //遍历个位
                    for (char c4 : arr) {
                        //如果个位和十、百、千位数字相同，跳出
                        if(c == c4 || c2 == c4 || c3 == c4){
                            continue;
                        }
                        //千位为0时，省略掉千位
                        if(c=='0'){
                            //千位为0的输出，输出时前面加上空字符串，用于转义
                            System.out.println(""+c2+c3+c4);
                        }else{
                            //千位不为0的输出
                            System.out.println(""+c+c2+c3+c4);
                        }
                    }
                }
            }
        }
    }
}
