package com.company;

/**
 * @author joy
 * @date 2021/7/29
 * 豆浆机
 */
public abstract class SoymilkMachine {
    /**
     * 制造豆浆
     */
    public void makeSoymilk(){
        //模版函数
        this.operation1();
        this.operation2();
        this.operation3();
        this.operation4();
    }

    public abstract void operation1();
    public abstract void operation2();
    public abstract void operation3();
    public abstract void operation4();
}
