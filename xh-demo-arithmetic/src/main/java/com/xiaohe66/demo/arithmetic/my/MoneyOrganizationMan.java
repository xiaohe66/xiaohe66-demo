package com.xiaohe66.demo.arithmetic.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 传入一个总数，一个待选的钱集合，返回一个符合总数的钱集合（见单元测试）
 *
 * @author xiaohe
 * @time 2020.08.05 15:53
 */
public class MoneyOrganizationMan implements Comparator<MoneyOrganizationMan.Money> {


    public Money[] calculate(int value, Money[] haveMoneyArr) {
        Arrays.sort(haveMoneyArr,this);

        List<Money> result = new ArrayList<>();

        calculate(value, haveMoneyArr, 0, result);

        return result.toArray(new Money[0]);
    }

    private void calculate(int value, Money[] haveMoneyArr, int start, List<Money> result) {
        if (start >= haveMoneyArr.length) {
            return;
        }

        Money money;
        do {
            money = haveMoneyArr[start];
            if (money == null) {
                return;
            }
            start++;
        } while (money.val > value);

        int maxQty = value / money.val;
        if (money.qty < maxQty) {
            maxQty = money.qty;
        }

        if (maxQty * money.val == value) {
            result.add(new Money(money.val, maxQty));
            return;
        }


        Money retMoney = new Money(money.val, 0);
        result.add(retMoney);
        int originSize = result.size();

        for (int qty = maxQty; qty >= 0; qty--) {
            int needVal = value - money.val * qty;

            calculate(needVal, haveMoneyArr, start, result);

            if (result.size() > originSize) {
                retMoney.qty = qty;
                return;
            }
        }
        result.remove(originSize - 1);
    }

    @Override
    public int compare(Money o1, Money o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o2.val - o1.val;
    }

    public static class Money {
        int val;
        int qty;

        public Money(int val, int qty) {
            this.val = val;
            this.qty = qty;
        }

        @Override
        public String toString() {
            return "{" + "\"val\":\"" + val + "\""
                    + ",\"qty\":\"" + qty + "\""
                    + "}";
        }
    }
}
