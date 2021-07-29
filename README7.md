设计模式

### 第五章 模版模式

##### 作用：有一个模版函数，然后去执行一个算法，或者流程，然后这个算法和流程都需要自己继承这个抽象类实现

范例：豆浆制作

1.定义一个抽象类，里面含有一个模版方法

```java
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
```

2.放在子类实现抽象方法

```java
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

```

3.测试

```java
public class LightOffCommand implements Command{
  Light light;
  public LightOffCommand(Light light){
    this.light = light;
  }
  public void execute(){
    this.light.off();
  }
  
  public void undo(){
    this.light.on();
  }
}
```

