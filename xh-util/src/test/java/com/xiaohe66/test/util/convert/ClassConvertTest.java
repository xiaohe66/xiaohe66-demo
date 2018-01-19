package com.xiaohe66.test.util.convert;

import com.xiaohe66.util.convert.ClassUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author xh
 * @date 2018-1-19
 */
public class ClassConvertTest {

    @Test(expected = NullPointerException.class)
    public void test1(){
        ClassUtils.convert(null,new Obj1());
    }

    @Test(expected = NullPointerException.class)
    public void test2(){
        ClassUtils.convert(Obj2.class,null);
    }

    @Test
    public void test3(){
        Obj3 obj3 = ClassUtils.convert(Obj3.class,new Obj1());
        assertEquals(null,obj3);
    }

    @Test
    public void test4(){
        int integer1 = 1;
        int integer2 = 2;
        String str1 = "str1";
        String str2 = "str2";

        Obj1 obj1 = new Obj1(integer1,str1,str2,integer2);
        Obj2 obj2 = ClassUtils.convert(Obj2.class,obj1);

        assertEquals(integer1,obj2.getInteger());
        assertEquals(str1,obj2.getString());
        assertEquals(null,obj2.getObj1NotHave());
        assertEquals(0,obj2.getTypeDifferent());


    }
}
