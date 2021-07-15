

设计模式

### 第四章 工厂模式



------

### 基础重点

设计原则

依赖倒置：是程序要依赖于抽象接口，不要依赖于具体实现。 简单的说就是要求对抽象进行编程，不要对实现进行编程，这样就降低了客户与实现模块间的耦合。。

### 范例

披萨店

##### 简单工厂模式-产品接口

```java
package factoryDemo.demo1;
/**
 * @author joy zhou
 * @date 2021/7/16
 * 产品的抽象接口
 */
public interface IPizze {
    //多态显示的对象
    public void makePizze();
}

```

##### 产品类

```java
package factoryDemo.demo1;
/**
 * @author joy zhou
 * @date 2021/7/16
 */
public class CheesePizza implements IPizze{
    @Override
    public void makePizze() {
        System.out.printf("这个是芝士披萨");
    }
}
```

##### 简单工厂类

```java
package factoryDemo.demo1;
import java.util.HashMap;
import java.util.Map;
/**
 * @author joy zhou
 * @date 2021/7/15
 */
public class SimplePizzaFactory {
    //集合
    private static final Map<String,IPizze> map = new HashMap<>();
    static  {
        map.put("cheese",new CheesePizza());
    }
    public static IPizze createPizza(String type){
        return map.get(type);
    }
}
```

这个地方有一个优化，就是把很多的if语句优化掉了，让更多的披萨类进行加入就可以了

##### 测试

```java
package factoryDemo.demo1;
/**
 * @author joy zhou
 * @date 2021/7/16
 */
public class Main {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzeStore pizzeStore = new PizzeStore(simplePizzaFactory);
        pizzeStore.sellPizze("cheese").makePizze();
    }
}
```

总结：这个简单的工厂模式，实际上就是一个对产品做了一个多态的处理，然后根据不通的品种选择不同的产出披萨。

设计图如下

![](https://github.com/sanzhixiong1986/Design/blob/main/1.jpg)

------

##### 对披萨店的扩展，增加加盟店

```java
package factoryDemo.demo2;

/**
 * @author joy zhou
 * @date 2021/7/16
 */
public interface IPizzeStore {
    public IPizze sellPizze(String type);
}
```

##### 产品接口披萨

```java
package factoryDemo.demo2;

/**
 * @author joy zhou
 * @date 2021/7/16
 */
public interface IPizze {
    public void makePizze();
}
```

##### 然后我开了两个店一个是意大利的披萨店，一个是当地的披萨店

```java
package factoryDemo.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author joy
 * @date 2021/7/16
 * 意大利披萨店
 */
public class ItalianPizze implements IPizzeStore{
    private static Map<String , IPizze> map = new HashMap<>();
    static {
        map.put("cheese",new ItalianCheese());
    }
    @Override
    public IPizze sellPizze(String type) {
        return map.get(type);
    }
}
```

```java
package factoryDemo.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author joy
 * @date 2021/7/16
 * 美国味披萨店
 */
public class UsaPizzeStore implements IPizzeStore{
    private static Map<String , IPizze> map = new HashMap<>();

    static {
        map.put("cheese",new UseCheese());
    }

    @Override
    public IPizze sellPizze(String type) {
        return map.get(type);
    }
}
```

##### 售卖的产品

```java
package factoryDemo.demo2;

/**
 * @author joy
 * @date 2021/7/16
 */
public class UseCheese implements IPizze{
    @Override
    public void makePizze() {
        System.out.println("美国味的芝士披萨");
    }
}
```

```java
package factoryDemo.demo2;

/**
 * @author joy
 * @date 2021/7/16
 */
public class ItalianCheese implements IPizze{
    @Override
    public void makePizze() {
        System.out.printf("意大利味道的芝士披萨");
    }
}
```

##### 测试类

```java
package factoryDemo.demo2;

/**
 * @author joy
 * @date 2021/7/16
 */
public class demo2 {
    public static void main(String[] args) {
        IPizzeStore iPizzeStore1 = new ItalianPizze();
        IPizzeStore iPizzeStore2 = new UsaPizzeStore();
        iPizzeStore1.sellPizze("cheese").makePizze();
        iPizzeStore2.sellPizze("cheese").makePizze();
    }
}

```

------



##### 工厂方法模式

定义：定义一个创建对象的接口，但是由子嘞决定要实力话那个。工厂方法让类把实例化推迟到子类。

##### 增加一个接口是原料的接口

```java
package factoryDemo.demo3;

/**
 * @author joy
 * @date 2021/7/16
 */
public interface PizzaIngredientFactory {
    //增加芝士
    public Cheese createCheese();
}
```

这样通过方法进行类的创建

##### 总结：

抽象工厂和工厂方法

区别：一个是用继承，一个是用组合

工厂方法：通过子类覆盖父类的方式进行

抽象方法：通过接口来创建某一类产品，比如pizza的某一种原料

- 用法

抽象工厂：如果是创建产品家族可以用抽象工厂

工厂方法：平常都可以使用工厂方法

