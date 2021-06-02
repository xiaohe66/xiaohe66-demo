package com.xiaohe66.demo.se.reflect;

import java.lang.reflect.Field;

/**
 * 反射获取类的属性，包括private属性,同时修改值
 *
 * 对属性的操作主要是获取Field对象，Field对象包含
 *
 * @author xh
 * @date 17-12-20 020
 */
public class ReflectPropertyDemo {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.say();
        //1.获取Class对象
        Class cls = myClass.getClass();
        //2.通过getDeclaredFields()方法可以获取到该类的所有属性的Field对象
        Field[] fields = cls.getDeclaredFields();
        //3.遍历fields
        for (Field field : fields) {
            //获取参数名
            System.out.print(field.getName()+"\t");
            //获取参数类型
            System.out.println(field.getType());
            /*
             * 通过反射获取myClass对应属性的值
             */
            try {
                //将accessible的值设置为true后，会取消java的访问检查，即可访问私有属性
                field.setAccessible(true);
                System.out.println(field.get(myClass));

                //设置该属性的值，包括私有属性
                field.set(myClass,"反射修改的值");

            } catch (IllegalAccessException ignored) {}
        }
        myClass.say();
    }
}
