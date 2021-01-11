package com.vikko.demo.may;

import com.vikko.demo.april.Apple;

import java.util.Objects;

/**
 * @author vikko
 * @date 2020/5/28 11:39
 */
public class EntityPoolTest {
    public static void main(String[] args) {
        Student vikko = new Student(1, "vikko");
        Student vikko1 = new Student(1, "vikko");
        System.out.println(vikko.hashCode() == vikko1.hashCode());//true
        System.out.println(vikko == vikko1);//false
        System.out.println(Objects.equals(vikko,vikko1));//true
        System.out.println(vikko.equals(vikko1));//true

    }
}
