package com.xiaohe66.demo.arithmetic.bihu;

/**
 *
 * 	输出九九乘法表, 汉字型的, 如下：
        一 * 一 = 一
        一 * 二 = 二 二 * 二 = 四
        一 * 三 = 三 二 * 三 = 六 三 * 三 = 九
 * 基本思路：
 * 1.使用int类型的值进行遍历，得到数值型的结果后，再将其转换为中文
 * 2.定义一个中文的String数组，方便使用下标取值
 *
 * @author xh
 * @date 17-12-24 024
 */
public class Demo4 {
    /**
     * 定义一个中文的数组，方便使用下标进行取值
     */
    private static final String[] ARR = {"零","一","二","三","四","五","六","七","八","九","十"};

    /**
     * 1或2位的数值转换为中文
     * @param num 1或2位的数值
     * @return 转换后的中文
     */
    private static String cast(int num){
        //取十位的值
        int shi = num/10;
        if(shi == 0){
            //十位的值为0，表示num只有个位，直接返回对应的中文即可
            return ARR[num];
        }else{
            //十位的值不为0，表示num是一个2位数
            //对num进行取余，得到ge位数
            int ge = num%10;
            if(ge != 0){
                return ARR[shi]+ARR[10]+ARR[ge];
            }else{
                //个位数为0，不需要输出个位，例如20，只需要输出“二十”，而不用输出“二十零”
                return ARR[shi]+ARR[10];
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ARR[j]+" * "+ARR[i]+" = "+cast(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
