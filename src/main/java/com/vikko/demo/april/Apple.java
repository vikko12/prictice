package com.vikko.demo.april;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author vikko
 * @date 2020/4/27 15:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private String color;
    private Double weight;
    private String name;
}
