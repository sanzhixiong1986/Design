

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