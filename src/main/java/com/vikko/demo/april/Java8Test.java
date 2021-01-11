package com.vikko.demo.april;

import org.springframework.util.CollectionUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vikko
 * @date 2020/5/11 11:08
 */
public class Java8Test {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        List<String> collect = strings.stream().filter(data -> !data.equalsIgnoreCase("2")).collect(Collectors.toList());
        System.out.println(strings.size());
    }

    public static void test2(){
        List<String> strings = Arrays.asList("test1", "test2", "test1");
        strings = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(strings);
    }
}
