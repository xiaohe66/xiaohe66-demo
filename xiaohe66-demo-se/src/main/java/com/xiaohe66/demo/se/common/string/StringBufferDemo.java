package com.xiaohe66.demo.se.common.string;

/**
 * StringBuffer和String有本质的区别：
 *
 * String是常量类型的，因此在修改String对象时，会创建新的对象
 * 而StringBuffer就是String的变量版本
 * 在需要对字符串进行较多运算时，就可以使用StringBuffer类
 *
 * @author xh
 * @date 17-12-20 020
 */
public class StringBufferDemo {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("我");
        stringBuffer.append("是");
        stringBuffer.append("小");
        stringBuffer.append("何");

        System.out.println(stringBuffer);
    }
}
