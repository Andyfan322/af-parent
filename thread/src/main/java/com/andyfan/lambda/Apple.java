package com.andyfan.lambda;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author andyFan
 * @since 2019年01月04日
 */
@Data
@Accessors(chain = true)
public class Apple {
    public Apple(Integer weight, String country) {
        this.weight = weight;
        this.country = country;
    }

    public Apple() {
    }

    private Integer weight;
    private String country;
}
