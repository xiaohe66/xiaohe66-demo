package com.xiaohe66.demo.se.base.Exception;

/**
 * @author xiaohe
 * @date 17-12-08
 *
 * RuntimeException --> 非检查型异常
 * 自定义运行时异常d
 * 继承RuntimeException，自行抛出此该异常时，不用使用try捕获可以编译
 */
public class DiyRuntimeException extends RuntimeException{

    public DiyRuntimeException(String message) {
        super(message);
    }

    /**
     * 带异常链的构造方法
     * @param message 异常消息
     * @param cause 异常链
     */
    public DiyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        //抛出runtimeException时不用捕获即可编译
        throw new DiyRuntimeException("");
    }
}
