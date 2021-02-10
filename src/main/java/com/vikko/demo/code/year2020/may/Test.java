package com.vikko.demo.code.year2020.may;

import java.util.Calendar;
import java.util.Date;

/**
 * @author vikko
 * @date 2020/5/13 18:55
 */
public class Test {
    public static void main(String[] args) {
        String format = String.format("%s", "成都");
        System.out.println(format);
    }

    private static Date formatIssueDate(Integer mins) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, mins * -1);
        return cal.getTime();
    }
}
