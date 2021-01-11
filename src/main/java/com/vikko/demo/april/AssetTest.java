package com.vikko.demo.april;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;

@Slf4j
public class AssetTest {

    public static void main(String[] args) {
        try {
            HashSet<String> set = new HashSet<>();
            Assert.isTrue(!CollectionUtils.isEmpty(set),"this set is empty!");
            System.out.println("hello world!");
        } catch (Exception e) {
         log.error("ciq跑马灯数据查询异常",e);
        }
    }
}
