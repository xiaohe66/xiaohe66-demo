package com.xiaohe66.util.convert;

import java.lang.reflect.Field;

/**
 * @author xh
 * @date 2018-1-19
 * @version 1.0.1
 *      <p>超类的属性，也可以复制
 */
public class ClassUtils {

    /**
     * 不同类的同名同类型属性复制
     *
     * @param targetCls 目标类的Class对象<br>
     *                  该类必须要有public的无参构造方法，否则无法通过反射创建实例
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
        T targetObj;
        try {
            targetObj =  targetCls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        /*
        * 获取源类的Class，通过反射获取该类所有的字段（不包括超类）
        * */
        Class sourceClass =  sourceObj.getClass();

        /*
        * 源类的字段，一开始保存的是当前类的字段，在循环时，保存的是超类的字段
        * */
        Field[] sourceOperandFields;

        /*
        * 当前操作的类。一开始保存的是源类Class，在循环时，保存的是超类的Class
        * */
        Class sourceOperandCls = sourceClass;

        /*
        * 目标操作中的class
        * */
        Class targetOperandCls;

        String fieldName;
        Field targetOperandField;
        Object val;

        //取当前源类，和源的超类
        while (sourceOperandCls != null){

            sourceOperandFields = sourceOperandCls.getDeclaredFields();

            for (Field sourceOperandField : sourceOperandFields) {
                //初始化目标class
                targetOperandCls = targetCls;

                //获取源成员名称
                fieldName = sourceOperandField.getName();

                targetOperandField = null;
                /*
                * 遍历每一个目标类的超类
                * 获取目标的Field对象，当前类找不到时，就去超类找
                * */
                while(targetOperandField == null && targetOperandCls != null){
                    try {
                        targetOperandField = targetOperandCls.getDeclaredField(fieldName);
                    } catch (NoSuchFieldException e) {
                        //当前类未获取到，获取父类的
                        targetOperandCls = targetOperandCls.getSuperclass();
                    }
                }

                //未找到相关字段，跳出
                if(targetOperandField == null){
                    continue;
                }

                //类型不同，跳出
                if(!targetOperandField.getType().equals(sourceOperandField.getType())){
                    continue;
                }

                try {
                    //将accessible的值设置为true后，会取消java的访问检查，即可访问私有属性
                    sourceOperandField.setAccessible(true);
                    val = sourceOperandField.get(sourceObj);

                    //设置该属性的值，包括私有属性
                    targetOperandField.setAccessible(true);
                    targetOperandField.set(targetObj,val);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sourceOperandCls = sourceOperandCls.getSuperclass();
        }
        return targetObj;
    }
}
