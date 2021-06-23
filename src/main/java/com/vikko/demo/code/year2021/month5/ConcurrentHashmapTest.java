package com.vikko.demo.code.year2021.month5;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapTest {


    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        String put = map.put("test", "test");
        hashMap.put("test", "test");
    }
}
