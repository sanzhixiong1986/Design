设计模式

### 第五章 单利模式

##### 单利模式的基础代码

```java
package Singleton;

/**
 * @author joy
 * @date 2021/7/16
 */
public class Demo1 {
    private static Demo1 _inter = null;
    public static Demo1 getInterce(){
        if(_inter == null)
            _inter = new Demo1();

        return _inter;
    }
}
```

这里会有问题，一旦是用多线程，这个就肯定会有问题，多线程的操作可能是并发的1秒钟下面很多次，这里面会出现创建多次的情况，出现的问题是因为在一个时间内可能访问这个getInterce方法，瞬间判断为null的会有很多次，这样在多线程下面会有错误。

##### 直接解决的方案

```java
package Singleton;

/**
 * @author joy
 * @date 2021/7/16
 */
public class Demo2 {
    //2.创建私有对象
    private static Demo2 _inter = new Demo2();
    //1.构造函数为私有
    private Demo2(){};

    //3.创建一个静态方法返回这个对象
    public static Demo2 getInstance(){
        return _inter;
    }
}
```

  这个方案最简单，单利也很简单。



