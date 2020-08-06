package com.xiaohe66.demo.arithmetic.my;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MoneyOrganizationManTest {


    Random random = new Random(System.currentTimeMillis());

    MoneyOrganizationMan demo = new MoneyOrganizationMan();

    @Test
    public void testSort() {

        int qty = 10;

        MoneyOrganizationMan.Money[] arr = new MoneyOrganizationMan.Money[qty];

        for (int i = 0; i < qty; i++) {
            arr[i] = i % 3 == 0 ? null : new MoneyOrganizationMan.Money(random.nextInt(100), 1);
        }

        outArr1(arr);
        //Arrays.sort(arr,demo);
        outArr1(arr);
    }

    @Test
    public void test() {

        MoneyOrganizationMan.Money[] arr = new MoneyOrganizationMan.Money[]{
                new MoneyOrganizationMan.Money(8, 1),
                new MoneyOrganizationMan.Money(7, 1),
                new MoneyOrganizationMan.Money(6, 1),
                new MoneyOrganizationMan.Money(5, 1),
                new MoneyOrganizationMan.Money(4, 1),
                new MoneyOrganizationMan.Money(3, 1),
                new MoneyOrganizationMan.Money(2, 1),
                new MoneyOrganizationMan.Money(1, 1),
        };

        MoneyOrganizationMan.Money[] result = demo.calculate(20, arr);
        outArr2(result);
    }

    @Test
    public void test2() {

        MoneyOrganizationMan.Money[] arr = new MoneyOrganizationMan.Money[]{
                new MoneyOrganizationMan.Money(8, 2),
                new MoneyOrganizationMan.Money(7, 2),
                new MoneyOrganizationMan.Money(6, 2),
                new MoneyOrganizationMan.Money(5, 2),
                new MoneyOrganizationMan.Money(4, 2),
                new MoneyOrganizationMan.Money(3, 2),
                new MoneyOrganizationMan.Money(2, 2),
                new MoneyOrganizationMan.Money(1, 2),
        };

        MoneyOrganizationMan.Money[] result = demo.calculate(73, arr);
        outArr2(result);
    }

    @Test
    public void test3() {

        MoneyOrganizationMan.Money[] arr = new MoneyOrganizationMan.Money[]{
                new MoneyOrganizationMan.Money(8, 3),
                new MoneyOrganizationMan.Money(7, 4),
                new MoneyOrganizationMan.Money(6, 5),
                new MoneyOrganizationMan.Money(4, 3),
                new MoneyOrganizationMan.Money(3, 4),
                new MoneyOrganizationMan.Money(2, 5),
                new MoneyOrganizationMan.Money(1, 6),
        };

        MoneyOrganizationMan.Money[] result = demo.calculate(30, arr);
        outArr2(result);
    }

    private void outArr1(MoneyOrganizationMan.Money[] arr) {
        for (MoneyOrganizationMan.Money money : arr) {
            System.out.print(money == null ? null : money.val);
            System.out.print(',');
        }
        System.out.println();
    }

    private void outArr2(MoneyOrganizationMan.Money[] arr) {
        for (MoneyOrganizationMan.Money money : arr) {
            System.out.print(money.val);
            System.out.print('*');
            System.out.print(money.qty);
            System.out.println();
        }
    }
}
