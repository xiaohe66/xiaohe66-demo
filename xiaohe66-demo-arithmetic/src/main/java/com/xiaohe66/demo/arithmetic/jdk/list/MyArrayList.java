package com.xiaohe66.demo.arithmetic.jdk.list;

import java.util.Arrays;

/**
 * @author xiaohe
 * @date 2019.04.12 12:18
 */
public class MyArrayList<E>{

    private static final Object[] EMPTY_LIST = {};

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;

    private int size;

    public MyArrayList() {
        data = EMPTY_LIST;
    }

    public MyArrayList(int capacity) {
        data = new Object[capacity];
    }


    public boolean add(E obj){
        if(size >= data.length){
            grow();
        }
        data[size++] = obj;
        return true;
    }

    @SuppressWarnings("unchecked")
    private E data(int index){
        return (E) data[index];
    }


    public E get(int index){
        checkIndex(index);
        return data(index);
    }

    public E remove(int index){
        checkIndex(index);
        E e = data(index);

        System.arraycopy(data,index+1,data,index,size-index-1);
        data[--size] = null;

        return e;
    }

    /**
     * 扩容
     * todo : 超过 MaxInt 的时候如何处理
     */
    private void grow(){
        System.out.print("需要扩容");
        int newCapacity;
        int oldCapacity = data.length;
        if(data == EMPTY_LIST){
            newCapacity = DEFAULT_CAPACITY;
        }else{
            newCapacity = oldCapacity + (oldCapacity >> 1);
        }
        System.out.println(",原容量："+oldCapacity+",新容量："+newCapacity);
        data = Arrays.copyOf(data,newCapacity);
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("size:"+size+",index:"+index);
        }
    }

}
