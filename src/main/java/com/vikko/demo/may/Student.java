package com.vikko.demo.may;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author vikko
 * @date 2020/5/28 11:41
 */
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
