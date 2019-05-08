package com.xiaohe66.demo.se.base.Exception;

/**
 * @author xiaohe
 * @time 19-05-06 13:58
 *
 *
 */
public class TryReturn2 {
    static int test(){
        // init i = 0.
        int i = 0;
        try{
            i++;
            // this i is 1.
            System.out.println("try i : "+i);
            return i;
        }finally {
            i++;
            // this i is 2.
            System.out.println("finally i : "+i);
        }
    }

    public static void main(String[] args) {
        // why this i is not 2 ?
        System.out.println("main i : "+test());
    }
}
