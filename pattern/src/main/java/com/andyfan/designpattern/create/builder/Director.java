package com.andyfan.designpattern.create.builder;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class Director {

    private AbstractBuilder builder;

    private Integer condition;

    public Director(AbstractBuilder builder, Integer condition) {
        this.builder = builder;
        this.condition = condition;
    }

    public void build(AbstractBuilder builder) {
        switch (condition) {
            case 1:
                builder.buildPart1();
                break;
            case 2:
                builder.buildPart2();
                break;
            case 3:
                builder.buildPart3();
                break;
            default:
                builder.buildPart1();
        }
    }
}
