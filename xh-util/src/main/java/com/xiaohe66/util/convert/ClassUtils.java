package com.xiaohe66.util.convert;

import java.lang.reflect.Field;

/**
 * @author xh
 * @date 2018-1-19
 */
public class ClassUtils {

    /**
     * 不同类的同名同类型属性复制
     *
     * @param targetCls
     *          目标类的Class对象，该类必须要有public的无参构造方法，否则无法通过反射创建实例
     * @param sourceObj 源类的实例
     * @param <T> 目标类
     * @return 目标类的实例
     */
    public static <T> T convert(Class<T> targetCls, Object sourceObj){

        /*
        * 判断参数是否为null
        * */
        if(targetCls == null || sourceObj == null){
            throw new NullPointerException("targetCls or sourceObj is null");
        }

        /*
        * 创建目标类的实例
        * */
        T targetObj = null;
        try {
            targetObj =  targetCls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        /*
        * 获取源类的Class，通过反射获取所有的字段
        * */
        Class sourceClass =  sourceObj.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();

        for (Field sourceField : sourceFields) {

            String fieldName = sourceField.getName();

            //获取目标的Field对象
            Field targetField = null;
            try {
                targetField = targetCls.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                System.out.println("字段\t"+fieldName+"\t在目标类中没有找到");
                continue;
            }

            //没有找到相同的字段，跳出
            if(targetField == null){
                continue;
            }

            //类型不同，跳出
            if(!targetField.getType().equals(sourceField.getType())){
                continue;
            }

            try {
                //将accessible的值设置为true后，会取消java的访问检查，即可访问私有属性
                sourceField.setAccessible(true);
                Object val = sourceField.get(sourceObj);

                //设置该属性的值，包括私有属性
                targetField.setAccessible(true);
                targetField.set(targetObj,val);

            } catch (IllegalAccessException ignored) {}
        }

        return targetObj;
    }

}
