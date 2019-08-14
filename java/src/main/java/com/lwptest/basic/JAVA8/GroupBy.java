package com.lwptest.basic.JAVA8;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liwanping
 * @since 2019-08-07
 */
public class GroupBy {
    @Data
    private static  class Pojo{
        private String foo;
        private String bar;

        public Pojo(String foo, String bar) {
            this.foo = foo;
            this.bar = bar;
        }
    }

    public static void main (String[] args ){
        List<Pojo> list = new ArrayList<>();
        list.add(new Pojo("22","44"));
        list.add(new Pojo("22","33"));
        list.add(new Pojo("22","11"));
        list.add(new Pojo("33","55"));
        list.add(new Pojo("33","55"));
        list.add(new Pojo("33","66"));
        Map<String,Pojo> map = list.stream()
                .collect(Collectors.toMap(Pojo::getFoo, Function.identity(),
                        BinaryOperator.minBy(Comparator.comparing(Pojo::getBar))));
        System.out.println(map);
        List<Pojo> newList  = list.stream().filter(x->{
           if (x.foo=="22") return true;
           else return false;
        }).collect(Collectors.toList());
        System.out.println(newList);
    }
}
