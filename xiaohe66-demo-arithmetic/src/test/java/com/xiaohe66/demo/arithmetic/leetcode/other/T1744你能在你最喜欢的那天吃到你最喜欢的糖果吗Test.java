package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T1744你能在你最喜欢的那天吃到你最喜欢的糖果吗Test {

    T1744你能在你最喜欢的那天吃到你最喜欢的糖果吗 demo = new T1744你能在你最喜欢的那天吃到你最喜欢的糖果吗();

    @Test
    public void test1() {

        assertArrayEquals(new boolean[]{true, false, true}, demo.canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{
                new int[]{0, 2, 2},
                new int[]{4, 2, 4},
                new int[]{2, 13, 1000000000}}));

        assertArrayEquals(new boolean[]{false,true,true,false,false}, demo.canEat(new int[]{5,2,6,4,1}, new int[][]{
                new int[]{3,1,2},
                new int[]{4,10,3},
                new int[]{3,10,100},
                new int[]{4,100,30},
                new int[]{1,3,1}}));


    }

    @Test
    public void test2() {

        boolean[] correct = {true,true,true,true,true,true,true,true,false,false,true,true,false,false,false,true,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,true,true,false,false,false,true,false,false,false,false,false,true,true,true,false,false,false,false,true,false,false,true,false,true,true,false,true,false,false,true,true,true,true,true,false,false,false,true,true,false,false,true,false,true};
        int[] arr = new int[]{16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42, 28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16, 23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8};
        int[][] arr2 = {new int[]{35, 669, 5}, new int[]{72, 822, 74}, new int[]{47, 933, 94}, new int[]{62, 942, 85}, new int[]{42, 596, 11}, new int[]{56, 1066, 18}, new int[]{54, 571, 45}, new int[]{39, 890, 100}, new int[]{3, 175, 26}, new int[]{48, 1489, 37}, new int[]{40, 447, 52}, new int[]{30, 584, 7}, new int[]{26, 1486, 38}, new int[]{21, 1142, 21}, new int[]{9, 494, 96}, new int[]{56, 759, 81}, new int[]{13, 319, 16}, new int[]{20, 1406, 57}, new int[]{11, 1092, 19}, new int[]{24, 670, 67}, new int[]{38, 1702, 33}, new int[]{5, 676, 32}, new int[]{50, 1386, 77}, new int[]{36, 1551, 87}, new int[]{29, 1445, 13}, new int[]{58, 977, 13}, new int[]{7, 887, 64}, new int[]{37, 1396, 23}, new int[]{0, 765, 69}, new int[]{40, 1083, 86}, new int[]{43, 1054, 49}, new int[]{48, 690, 92}, new int[]{28, 1201, 56}, new int[]{47, 948, 43}, new int[]{57, 233, 25}, new int[]{32, 1293, 65}, new int[]{0, 1646, 34}, new int[]{43, 1467, 39}, new int[]{39, 484, 23}, new int[]{21, 1576, 69}, new int[]{12, 1222, 68}, new int[]{9, 457, 83}, new int[]{32, 65, 9}, new int[]{10, 1424, 42}, new int[]{35, 534, 3}, new int[]{23, 83, 22}, new int[]{33, 501, 33}, new int[]{25, 679, 51}, new int[]{2, 321, 42}, new int[]{1, 240, 68}, new int[]{7, 1297, 42}, new int[]{45, 480, 72}, new int[]{26, 1472, 9}, new int[]{6, 649, 90}, new int[]{26, 361, 57}, new int[]{49, 1592, 7}, new int[]{11, 158, 95}, new int[]{35, 448, 24}, new int[]{41, 1654, 10}, new int[]{61, 510, 43}, new int[]{31, 1230, 95}, new int[]{11, 1471, 12}, new int[]{37, 43, 84}, new int[]{56, 1147, 48}, new int[]{69, 1368, 65}, new int[]{22, 170, 24}, new int[]{56, 192, 80}, new int[]{34, 1207, 69}, new int[]{1, 1226, 22}, new int[]{37, 1633, 50}, new int[]{11, 98, 58}, new int[]{17, 125, 13}, new int[]{0, 1490, 5}, new int[]{37, 1732, 43}, new int[]{45, 793, 14}, new int[]{16, 578, 72}, new int[]{50, 241, 78}};

        assertArrayEquals(correct,demo.canEat(arr,arr2));
    }

    @Test
    public void test3() {

        boolean[] correct = {false,false,false,false,true,false,false,false,false,false,false,true,true,false,true,true,true,true,false,false,false,false,true,false,true,true,false,false,false,true,false,true,false,false,true,false,false,false,false,true,true,false,true,true,false,false,true,true,true,true,true,true,true,false,true,false,true,true,true,true,true,false,false,true,true,false,true,false,false,false,true,true,false,true,false,true,true,false,false,true,false,true,false,true,true,true,true,false,true,false,false,true,true,true};
        int[] arr = new int[]{46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5};
        int[][] arr2 = {new int[]{80,2329,69},new int[]{14,1485,76},new int[]{33,2057,83},new int[]{13,1972,27},new int[]{11,387,25},new int[]{24,1460,47},new int[]{22,1783,35},new int[]{1,513,33},new int[]{66,2124,85},new int[]{19,642,26},new int[]{15,1963,79},new int[]{93,722,96},new int[]{15,376,88},new int[]{60,1864,89},new int[]{86,608,4},new int[]{98,257,35},new int[]{35,651,47},new int[]{96,795,73},new int[]{62,2077,18},new int[]{27,1724,57},new int[]{34,1984,75},new int[]{49,2413,95},new int[]{76,1664,5},new int[]{28,38,13},new int[]{85,54,42},new int[]{12,301,3},new int[]{62,2016,29},new int[]{45,2316,37},new int[]{43,2360,28},new int[]{87,192,98},new int[]{27,2082,21},new int[]{74,762,37},new int[]{51,35,17},new int[]{73,2193,4},new int[]{60,425,65},new int[]{11,1522,58},new int[]{21,1699,66},new int[]{42,1473,5},new int[]{30,2010,48},new int[]{91,796,74},new int[]{82,2162,31},new int[]{23,2569,65},new int[]{24,684,23},new int[]{70,1219,51},new int[]{5,1817,15},new int[]{81,2446,34},new int[]{96,771,60},new int[]{49,1171,60},new int[]{41,567,67},new int[]{39,799,59},new int[]{90,957,81},new int[]{84,2122,27},new int[]{82,1707,44},new int[]{11,1889,20},new int[]{80,1697,83},new int[]{24,1786,60},new int[]{90,1847,99},new int[]{51,114,21},new int[]{44,466,85},new int[]{56,469,20},new int[]{44,350,96},new int[]{66,1946,10},new int[]{14,2470,12},new int[]{69,1175,18},new int[]{98,1804,25},new int[]{77,2187,40},new int[]{89,2265,45},new int[]{19,2246,45},new int[]{40,2373,79},new int[]{60,2222,17},new int[]{37,385,5},new int[]{97,1759,97},new int[]{10,903,5},new int[]{87,842,45},new int[]{74,2398,66},new int[]{62,49,94},new int[]{48,156,77},new int[]{76,2310,80},new int[]{64,2360,95},new int[]{70,1699,83},new int[]{39,1241,66},new int[]{92,2312,21},new int[]{63,2148,29},new int[]{95,594,74},new int[]{89,90,51},new int[]{82,137,70},new int[]{54,301,97},new int[]{15,819,43},new int[]{47,1402,60},new int[]{17,2377,43},new int[]{50,1937,95},new int[]{62,1174,74},new int[]{67,1411,87},new int[]{39,1151,48}};

        assertArrayEquals(correct,demo.canEat(arr,arr2));
    }

    @Test
    public void test4() {


        boolean[] correct = {false,true,true,false,true,false,false,false,false,false,true,false,true,true,true,false,false,false,false,true,false,false,true,true,false,false,true,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,false,true,true,false,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,false,true,false};
        int[] arr = new int[]{5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
        int[][] arr2 = {new int[]{46,4191056,444472063},new int[]{75,865431,146060662},new int[]{91,244597,840227137},new int[]{89,2601754,901415801},new int[]{69,1777314,444098682},new int[]{78,2957259,231019870},new int[]{19,4350225,516815116},new int[]{42,4081198,594990005},new int[]{59,3176552,508520222},new int[]{77,4577766,38900694},new int[]{92,320256,1362},new int[]{44,3992014,7209},new int[]{55,1950613,1370},new int[]{97,734069,3066},new int[]{39,1188632,661},new int[]{58,4526426,6202},new int[]{51,3083812,1767},new int[]{46,2563654,9680},new int[]{21,4012578,7014},new int[]{66,2185952,7039},new int[]{67,3712445,1239},new int[]{0,1840130,185},new int[]{35,605159,7105},new int[]{94,2269908,416},new int[]{68,4117247,2076},new int[]{0,4540381,2412},new int[]{20,579583,8917},new int[]{62,4407388,7127},new int[]{17,4468545,6287},new int[]{50,3462654,1410},new int[]{7,1883037,77},new int[]{4,4089924,5849},new int[]{5,4340465,3843},new int[]{68,596099,5796},new int[]{29,542371,5952},new int[]{91,441898,2227},new int[]{35,912775,6110},new int[]{12,267236,3248},new int[]{27,990261,771},new int[]{76,320119,5220},new int[]{23,738123,2504},new int[]{66,439801,4436},new int[]{18,372357,1654},new int[]{51,846227,5325},new int[]{80,502088,3751},new int[]{49,117408,102},new int[]{75,837527,8747},new int[]{46,984134,7924},new int[]{42,463312,7558},new int[]{50,214995,1043},new int[]{94,981465,6758},new int[]{79,892988,1063},new int[]{17,985872,2314},new int[]{71,870151,2004},new int[]{63,793308,7608},new int[]{49,873121,2846},new int[]{32,453564,3739},new int[]{42,890492,6026},new int[]{19,278107,2649},new int[]{64,792101,2208},new int[]{98,577463,526},new int[]{41,572006,748},new int[]{99,478120,895},new int[]{52,224338,423},new int[]{83,532978,600},new int[]{67,92281,486},new int[]{28,829955,925},new int[]{22,171381,749},new int[]{82,986821,603},new int[]{57,294692,194},new int[]{9,730892,973},new int[]{69,241093,931},new int[]{70,646855,27},new int[]{45,233480,669},new int[]{60,369922,965},new int[]{27,935011,659},new int[]{96,667580,837},new int[]{7,919344,188},new int[]{99,584762,131},new int[]{5,93173,898},new int[]{16,736395,184},new int[]{57,893061,196},new int[]{28,352640,924},new int[]{87,980414,80},new int[]{88,432895,129},new int[]{23,461032,85},new int[]{73,645991,268},new int[]{5,241036,458},new int[]{9,422324,785},new int[]{28,124913,224},new int[]{51,815633,765},new int[]{59,894120,559},new int[]{70,459876,192},new int[]{80,423125,584},new int[]{85,824496,142},new int[]{18,578975,104},new int[]{56,477816,303},new int[]{6,702127,400},new int[]{43,35371,850},new int[]{3,226423,10}};

        assertArrayEquals(correct,demo.canEat(arr,arr2));

    }

    //@Test
    public void testValueOut() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / (10 * 10000 * 10000));

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MAX_VALUE / (10 * 10000 * 10000) / (10 * 10000 * 10000));


    }
}