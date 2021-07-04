# Design
设计模式

### 第一章 设计模式入门

接口基础

------

### 基础

抽象

封装

多态

继承

### 原则

封装变化

多用组合，少用继承

针对接口编程，不针对实现编程

### 圆桌武士

角色

```java
public interface ICharacter {
    //战斗的方法
    public void fighting();
    //拿什么武器
    public void setArms(IWeapon iWeapon);
}
```

角色的继承类，国王，王子，猎人

```java
public class King implements ICharacter{
    @Override
    public void fighting() {
        System.out.println("国王在战斗");
    }

    @Override
    public void setArms(IWeapon iWeapon) {
        iWeapon.userWeapon();
    }
}
```

```java
public class Prince implements ICharacter{
    @Override
    public void fighting() {
        System.out.println("王子在战斗");
    }

    @Override
    public void setArms(IWeapon iWeapon) {
        iWeapon.userWeapon();
    }
}
```

```java
public class Hunter implements ICharacter{
    @Override
    public void fighting() {
        System.out.println("猎人");
    }

    @Override
    public void setArms(IWeapon iWeapon) {
        iWeapon.userWeapon();
    }
}
```

武器

```java
public interface IWeapon {
  	//使用什么武器的方法
    public void userWeapon();
}
```

各种武器

```java
public class Sword implements IWeapon{
    @Override
    public void userWeapon() {
        System.out.println("在使用宝剑");
    }
}
```

```java
public class Cross implements IWeapon{
    @Override
    public void userWeapon() {
        System.out.println("十字剑");
    }
}
```

```java
public class Arrow implements IWeapon{
    @Override
    public void userWeapon() {
        System.out.println("使用弓箭");
    }
}
```

测试类

```java
public class Main {
    public static void main(String[] args) {
        ICharacter character = new King();
        character.fighting();
        character.setArms(new Arrow());
    }
}
```

### 总结

1.使用了接口，然后继承接口，多态

2.使用多个接口进行组合，让每一个都可能更有扩展性