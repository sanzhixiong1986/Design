# Design
设计模式

### 第二章 观察者模式



------

### 基础重点

设计原则

为了交互对象之间的松耦合设计而努力。

### 范例

设计一个天气预报版的功能。

##### 主题接口

```java
public interface ISubject {
    //注册和删除
    public void registerObserver(IObserver o);
    public void removeObserver(IObserver o);
    public void notifyObserver();
}
```

##### 观察者

```java
public interface IObserver {
    public void update(float temp,float humidity,float pressure);
}
```

##### 显示类继承

```java
public interface IDisplayElement {
    public void display();
}
```

##### 继承主题数据结构

```java
package demo1;

import java.util.ArrayList;

/**
 * @author joy
 * @date 2021/7/4
 */
public class WeatherData implements ISubject {
    private ArrayList observer;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        this.observer = new ArrayList();
    }

    @Override
    public void registerObserver(IObserver o) {
        this.observer.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        int index = this.observer.indexOf(o);
        if(index >= 0){
            this.observer.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        final int len = this.observer.size();
        //通知所有观察者对象
        for (int i = 0; i < len; i++) {
            IObserver observer = (IObserver)this.observer.get(i);
            observer.update(temp,humidity,pressure);
        }
    }

    //更新数据就通知
    private void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
```

##### 显示对象

```java
package demo1;
/**
 * @author joy zhou
 * @date 2021/7/4
 */
public class CurrentConditionsDisplay implements IObserver,IDisplayElement{
    private float temp;
    private float humidity;
    private float pressure;
    private ISubject weatherData;

    public CurrentConditionsDisplay(ISubject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("update:"+this.temp +"-"+this.humidity+"-"+this.pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }
}

```

##### 测试

```java
package demo1;

/**
 * @author joy zhou
 * @date 2021/7/4
 */
public class demo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(81,67,29.4f);
        weatherData.setMeasurements(82,44,28.4f);
    }
}

```

