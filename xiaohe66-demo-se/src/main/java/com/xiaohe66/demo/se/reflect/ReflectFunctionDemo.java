package com.xiaohe66.demo.se.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * @author xh
 * @date 17-12-20 020
 */
public class ReflectFunctionDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();

        //1.获取class对象
        Class cls = myClass.getClass();

        /*
        2.获取class所有的的方法，不含继承的
            此外，getMethods()是获取所有的方法（包括继承的）
         */
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.print(method.getName()+":");
            //获取方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                //获取参数的类型
                Type type = parameter.getParameterizedType();
                System.out.print(type.getTypeName()+"\t");

            }
            System.out.println();
        }

        //通过方法名获取Method对象
        Method method = cls.getDeclaredMethod("func1");
        //设置方法调用时忽略访问权限
        method.setAccessible(true);
        method.invoke(myClass);

    }
}
