package com.xiaohe66.demo.spring.aop.changretval.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop改变返回值测试
 *
 * @author xh
 * @version 1.0
 * @date 2018-05-30 09:57
 *
 * @see ChangReturnValueAsp
 * @see ChangReturnValMain
 */
public class ChangReturnValTest {

    private ChangReturnValMain changReturnValMain;

    public ChangReturnValTest(){
        String xmlPath = "classpath:com/xiaohe66/demo/spring/aop/changretval/test/spring-aop-changretval.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        changReturnValMain = (ChangReturnValMain)context.getBean("changReturnValMain");
    }

    @Test
    public void test1(){
        System.out.println("最终值="+changReturnValMain.doTask("value"));
    }

    @Test
    public void test2(){
        System.out.println("最终值="+changReturnValMain.doTask2("value"));
    }

}
