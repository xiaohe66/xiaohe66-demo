package com.xiaohe66.demo.arithmetic.leetcode.other;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class T1418点菜展示表Test {

    private T1418点菜展示表 demo = new T1418点菜展示表();

    @Test
    public void test1() {

        test("[[Table,gbjd],[2,1]]", "[[xiaohe,2,gbjd]]");

        assertTrue(test("[[Table,Beef Burrito,Ceviche,Fried Chicken,Water],[3,0,2,1,0],[5,0,1,0,1],[10,1,0,0,0]]",
                "[[David,3,Ceviche],[Corina,10,Beef Burrito],[David,3,Fried Chicken],[Carla,5,Water],[Carla,5,Ceviche],[Rous,3,Ceviche]]"));

        assertTrue(test("[[Table,Canadian Waffles,Fried Chicken],[1,2,0],[12,0,3]]",
                "[[James,12,Fried Chicken],[Ratesh,12,Fried Chicken],[Amadeus,12,Fried Chicken],[Adam,1,Canadian Waffles],[Brianna,1,Canadian Waffles]]"));

        assertTrue(test("[[Table,Bean Burrito,Beef Burrito,Soda],[2,1,1,1]]",
                "[[Laura,2,Bean Burrito],[Jhon,2,Beef Burrito],[Melissa,2,Soda]]"));


    }


    public boolean test(String correct, String origin) {

        List<List<String>> correctList = LeetCodeUtils.stringToList2(correct);
        List<List<String>> ret = demo.displayTable(LeetCodeUtils.stringToList2(origin));
        boolean ans = correctList.equals(ret);
        if (!ans) {
            System.err.println("need : " + correct);
            System.err.println("but : " + ret);
        }
        return ans;
    }

}