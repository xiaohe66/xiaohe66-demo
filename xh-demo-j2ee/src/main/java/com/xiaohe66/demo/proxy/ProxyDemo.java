package com.xiaohe66.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理实现
 *
 * @author xh
 * @version 1.0
 * @time 2018-09-05 15:26
 */
public class ProxyDemo implements IProxy{

    public String test1(){
        System.out.println("------test1-----");
        return "test1 result";
    }

    public static void main(String[] args) {
        IProxy proxyDemo = (IProxy) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{IProxy.class}, new InvocationHandler() {
            ProxyDemo helloWord = new ProxyDemo();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("------调用前-----");
                Object result = method.invoke(helloWord,args);
                System.out.println("------调用后-----");
                System.out.println("result="+result);
                return result;
            }
        });
        proxyDemo.test1();
    }

}
interface IProxy{
    String test1();
}