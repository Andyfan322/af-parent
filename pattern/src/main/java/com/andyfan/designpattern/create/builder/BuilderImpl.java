package com.andyfan.designpattern.create.builder;

/**
 * @author andyFan
 * @since 2019年02月12日
 */
public class BuilderImpl extends AbstractBuilder {
    @Override
    void buildPart1() {
        System.out.println("构建对象第一步");
    }

    @Override
    void buildPart2() {
        System.out.println("构建对象第二步");
    }

    @Override
    void buildPart3() {
        System.out.println("构建对象第三步");
    }
}
