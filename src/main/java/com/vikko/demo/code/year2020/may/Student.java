package com.vikko.demo.code.year2020.may;

import lombok.AllArgsConstructor;

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
