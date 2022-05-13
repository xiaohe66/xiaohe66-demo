package com.xiaohe66.demo.se.java8;

import java.util.function.Predicate;

/**
 * 谓词
 * <p>
 * {@link Predicate#test}方法是他的基本方法，此外还有 {@link Predicate#and}和 {@link Predicate#or}等方法
 *
 * @author xiaohe
 * @since 2022.05.13 16:28
 */
public class PredicateDemo {

    private static Predicate<String> notEmptyPredicate = PredicateDemo::isNotEmpty;

    private static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static void main(String[] args) {

        System.out.println(isNotEmpty(""));
        System.out.println(notEmptyPredicate.test(""));

        System.out.println(isNotEmpty("123"));
        System.out.println(notEmptyPredicate.test("123"));

    }

}
