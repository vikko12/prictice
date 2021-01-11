package com.vikko.demo.june;

import com.alibaba.fastjson.JSONObject;

/**
 * @author vikko
 * @date 2020/6/18 17:48
 */
public class JsonTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test","test");
        System.out.println(jsonObject.toJSONString());
    }
}
