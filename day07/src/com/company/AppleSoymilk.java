package com.company;

/**
 * @author joy
 * @date 2021/7/29
 * 苹果豆浆
 */
public class AppleSoymilk extends SoymilkMachine{
    @Override
    public void operation1() {
        System.out.println("放入豆浆");
    }

    @Override
    public void operation2() {
        System.out.println("放入苹果");
    }

    @Override
    public void operation3() {
        System.out.println("搅拌");
    }

    @Override
    public void operation4() {
        System.out.println("完成");
    }
}
