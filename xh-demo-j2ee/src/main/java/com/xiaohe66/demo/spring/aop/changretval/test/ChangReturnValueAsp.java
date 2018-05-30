package com.xiaohe66.demo.spring.aop.changretval.test;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 切面改变返回值，切面类
 *
 * 使用环绕通知改变返回值
 *
 * @author xh
 * @version 1.0
 * @date 2018-05-30 09:46
 *
 * @see ChangReturnValMain
 */
public class ChangReturnValueAsp {

    /**
     * 切面的返回值和被切入方法的返回值相同
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    public Object change(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("开始切入");
        Object retVal = proceedingJoinPoint.proceed();
        System.out.println("原值="+retVal);

        //改变返回值
        retVal = "changVal";

        System.out.println("结束切入");
        return retVal;
    }

    /**
     * 切面的返回值和被切入方法的返回值不同
     *
     * 返回值不同时，若切面的返回值无法转换为被切入点的返回值，则会报类型转换异常
     * 因此，被切入点可以使用Object作为返回值类型，这样就可以进行切入了
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    public Object change2(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("开始切入");
        Object retVal = proceedingJoinPoint.proceed();
        System.out.println("原值="+retVal);

        //改变返回值
        Map<String,Object> map = new HashMap<>(16);
        map.put("status",1);
        map.put("val",retVal);

        System.out.println("结束切入");
        return map;
    }

}
