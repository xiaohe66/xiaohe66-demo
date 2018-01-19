package com.xiaohe66.demo.se.base.Exception;

/**
 * @author xh
 * @date 2017-12-8
 *
 * Exception --> 检查型异常
 * 自定义异常
 * 继承Exception，自行抛出此该异常时，需要使用try捕获才可以编译
 */
public class DiyException extends Exception{

    public DiyException(String message) {
        super(message);
    }

    public DiyException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        try {
            throw new DiyException("");
        } catch (DiyException e) {
            e.printStackTrace();
        }
    }
}
