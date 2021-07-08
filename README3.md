

设计模式

### 第三章 装饰者模式



------

### 基础重点

设计原则

使用多态的组合，让每一个抽象类型单独出来，以方便扩展。

### 范例

星巴克的组合简单范例

##### 抽象接口

```java
/**
 * @author joy zhou
 * @date 2021/7/8
 * 基础接口
 */
public interface Beverage {
    public String getDescription();
    public double cost();
}
```

##### 产品类

```java
package demo2;

/**
 * @author joy zhou
 * @date 2021/7/8
 * 产品
 */
public class Product implements Beverage {
    @Override
    public String getDescription() {
        return "酸柠浮冷萃(产品名)";
    }

    @Override
    public double cost() {
        return 0;
    }
}

```

##### 饮料的分类

```java
package demo2;

/**
 * @author joy zhou
 * @date 2021/7/8
 * 鸡尾酒威士忌酸
 */
public class Mocha implements Beverage {
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\n鸡尾酒威士忌酸(+1)";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}

```

##### 继承主题数据结构

```java
package demo2;

/**
 * @author joy zhou
 * @date 2021/7/8
 * 加类型2
 */
public class Ice implements Beverage{
    Beverage beverage;
    public Ice(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription()+"\n枫糖威士忌风味冷萃咖啡(+1)";
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 1;
    }
}

```

##### 测试

```java
package demo2;

/**
 * @author joy zhou
 * @date 2021/7/8
 */
public class demo2 {
    public static void main(String[] args) {
        Beverage beverage1 = new Product(); //产品
        beverage1 = new Mocha(beverage1);		//+1产品1
        beverage1 = new Ice(beverage1);			//+1产品2
        System.out.printf(beverage1.getDescription()+"\n$"+beverage1.cost());
    }
}
```

### 总结

这个模式还是利用了组合的原理进行封装，使用接口的多态来做整体的设计。