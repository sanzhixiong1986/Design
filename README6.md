设计模式

### 第五章 命令模式

##### 作用：解藕命令责和执行者

范例：遥控器控制家电

1.使用接口或者抽象对象对命令进行解偶

```java
public interface Command {
  public void execute();	
  public void undi();		//撤销
}
```

2.灯的命令实现，其中变量是一个具体的电器操作

```java
public class LightOnCommand implements Command{
  Light light;
  public LightOnCommand(Light light){
    this.light = light;
  }
  public void execute(){
    this.light.on();
  }
  
  public void undo(){
    this.light.off();
  }
}
```

3.灯的关操作

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

4.空的命令行

```java
public class NoCommand implements Command{
  public void execute(){}
  public void undo(){}
}
```

灯的类

```java
public class Light {
  public on(){
    System.out.printf("灯被打开");
  }
  
  public off(){
    System.out.printf("灯被关闭");
  }
}
```

5.遥控器的类

```java
public class RemoteController{
  Command[] onCommands;//开按钮
  Command[] offCommands;//关按钮
  Command undoCommand;//记录上一次
  
  public RemoteController(){
    //5个对应的开关按钮
    onCommands = new Command[5];
    offCommands = new Command[5];
    Command noCommand = new NoCommand();//这个是初始化命令按钮对象
    //初始化按钮，和命令行类型
    for(int i=0;i<5;i++){
      onCommands[i] = onCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }
 
  //设置命令
  //slot 是第几组的按钮
  public void setCommand(int slot,Command onCommand,Command offCommand){
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }
  
  //按钮第几组的打开
  public void onButtonWasPushed(int slot){
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }
  
  //关闭
  public void offButtonWasPushed(int slot){
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }
  
  //撤销
  public void undoButtonWasPushed(){
    undoCommand.undo();
  }
}
```

6.测试类

```java
public class Demo1{
  public static void main(String[] args){
    RemoteController remoteController = new RemoteController();
    //灯
    Light livingRoomLight = new Light();
    LightOnCommand lightOnCommand = new LightOnCommand(livingRoomLight);
    LightOffCommand lightOffCommand = new LightOffCommand(livingRoomLight);
    //遥控器按钮那个
    remoteController.setCommand(0,lightOnCommand,lightOffCommand);
    //按钮
    remoteController.onBuutonWasPushed(0);
    remoteController.offBuutonWasPushed(0);
    //撤销
    remoteController.undoButtonWasPushed();
  }
}
```

------

### 总结

命令模式是解偶发送命令者和接受命令者之间的关系，发送命令者不用理会是谁给接受者命令，而这个命令就是使用接口或者抽象类进行编写，这样就使用多态衍生了更多的对象进行命令的执行，在此测试类中，遥控器remoteController.setCommand(0,lightOnCommand,lightOffCommand);这段代码，遥控器只需要知道你是第几组，按钮的是那个按钮，至于是那个对象出发这个，就和你的命令有关系，这个命令就会对应你所操作的对象，这样，如果我要增加更多的可以在遥控器上可以控制别的家电，只需要增加对应的命令和对应的对象就可以，从而达到我只关系发送的命令，接受命令就和命令可以控制的对象绑定就不会有任何的耦合。
