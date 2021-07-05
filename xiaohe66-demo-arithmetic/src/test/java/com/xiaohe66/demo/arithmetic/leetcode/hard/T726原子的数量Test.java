package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T726原子的数量Test {

    private T726原子的数量 demo = new T726原子的数量();

    @Test
    public void test1() {


        assertEquals("A2", demo.countOfAtoms("(((Aa)11(Bb)11Bb(Cc)Bb11)11Cc(Cc)11)Cc11"));

        assertEquals("A2", demo.countOfAtoms("A2"));
        assertEquals("A", demo.countOfAtoms("A"));

        assertEquals("A15B7CG196H99J37583O2Rbcd154Sa1184", demo.countOfAtoms("H1O2A(Rbcd22A2Sa(G2(J767Sa23(GH)2)Sa)7)7SaB7C"));
        assertEquals("A15G196H99J37583O2Rbcd154Sa1190", demo.countOfAtoms("H1O2A(Rbcd22A2Sa1(G2(J767Sa23(GH)2)Sa)7)7Sa7"));
        assertEquals("A78G2156H1079J41353697O2R77S77", demo.countOfAtoms("H1O2A(RAS(G2(J76723(GH)2))7)77"));

        // 括号+数量+括号+数量+元素
        assertEquals("AH8O2", demo.countOfAtoms("(O(H2)2)2A"));
        assertEquals("AH4O2", demo.countOfAtoms("(H2O)2A"));

        assertEquals("H2O", demo.countOfAtoms("H2O"));
        assertEquals("H2MgO2", demo.countOfAtoms("Mg(OH)2"));
        assertEquals("K4N2O14S4", demo.countOfAtoms("K4(ON(SO3)2)2"));

    }


    @Test
    public void test2() {

        assertEquals("B18900Be18984C4200H5446He1386Li33894N50106O22638", demo.countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }
}