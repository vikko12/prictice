package com.vikko.demo.code.year2020.june;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author vikko
 * @date 2020/6/10 11:56
 */
public class Test {
    public static void main(String[] args) {
//        List<String> list = null;
//        list.forEach(data->{
//            System.out.println(data);
//        });
        Date date = new Date(1593360000000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
    }
    public static void put(Map map){
        map.put("test",1);
    }
}
