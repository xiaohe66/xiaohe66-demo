package com.xiaohe66.test.util.convert;

/**
 * @author xh
 * @date 2018-1-19
 */
public class Obj1 extends Obj{

    private int integer;
    private String string;
    private String obj2NotHave;
    private int obj2TypeDifferent;

    public Obj1(){

    }

    public Obj1(int integer, String string, String obj2NotHave, int obj2TypeDifferent) {
        this.integer = integer;
        this.string = string;
        this.obj2NotHave = obj2NotHave;
        this.obj2TypeDifferent = obj2TypeDifferent;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Obj1{" +
                "objI=" + objI +
                ", integer=" + integer +
                ", string='" + string + '\'' +
                ", obj2NotHave='" + obj2NotHave + '\'' +
                ", obj2TypeDifferent=" + obj2TypeDifferent +
                '}';
    }
}
