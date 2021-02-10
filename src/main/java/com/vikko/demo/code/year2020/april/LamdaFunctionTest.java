package com.vikko.demo.code.year2020.april;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author vikko
 * @date 2020/5/11 10:28
 */
public class LamdaFunctionTest {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("test2");
        test(strings,subList->{
            subList.add("test");
            return subList;
        });

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple("蓝色",22.0,"富士山苹果"));
        apples.add(new Apple("红色",23.0,"中国的苹果"));
        apples.add(new Apple("青色",21.0,"进口的苹果"));
        test(apples,subList->{
            List<Apple> originalApples = subList.stream().filter(data -> !data.getName().contains("富士山")).collect(Collectors.toList());
            return originalApples;
        });
    }

    public static  <R, T>List<R> test(List<T> source,Function<List<T>,List<R>> f){
        List<R> collect = new ArrayList();
        Optional<List<R>> optional = Optional.of(f.apply(source));
        List<R> rs = optional.get();
        collect.addAll(rs);
        System.out.println("collect == "+collect.toString());
        return collect.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }


}
