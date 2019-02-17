package com.andyfan.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author andyFan
 * @since 2019年01月04日
 * 比较器链
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        Comparator<Apple> c = comparing(Apple::getWeight);
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(1, "China"));
        list.add(new Apple(2, "Jap"));
        list.add(new Apple(1, "Am"));
        //比较器链
        list.sort(comparing(Apple::getWeight).thenComparing(Apple::getCountry).reversed());
        System.out.println(list);

    }
}
