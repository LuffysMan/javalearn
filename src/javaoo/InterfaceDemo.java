package javaoo;/*
@java接口
接口无法被实例化,但是可以被实现.一个实现接口的类,必须实现接口内所描述的所有方法,否则就必须声明为抽象类.
在Java中, 接口类型可用来声明一个变量, 他们可以成为一个空指针, 或是被绑定在一个以此接口实现的对象.
@@接口与类的区别：
    接口不能用于实例化对象.
    接口没有构造方法.
    接口中所有的方法必须是抽象方法(在jdk8之后有所改变, 允许有默认方法和静态方法实现, 分别用default和static修饰).
    接口不能包含成员变量,除了 static 和 final 变量.
    接口不是被类继承了,而是要被类实现.
    接口支持多继承
@@接口特性
    接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract,其他修饰符都会报错）.
    接口中可以含有变量,但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public,用 private 修饰会报编译错误）.
    接口中的方法是不能在接口中实现的,只能由实现接口的类来实现接口中的方法.
@@抽象类和接口的区别
    1. 抽象类中的方法可以有方法体,就是能实现方法的具体功能,但是接口中的方法不行.
    2. 抽象类中的成员变量可以是各种类型的,而接口中的成员变量只能是 public static final 类型的.
    3. 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法),而抽象类是可以有静态代码块和静态方法.
    4. 一个类只能继承一个抽象类,而一个类却可以实现多个接口.
    5. 抽象类和接口所反映出的设计理念不同. 其实抽象类表示的是"is-a"关系, 接口表示的是"like-a"关系.
 */

public class InterfaceDemo {
    public static void main(String[] args) {
        InterfaceDemo intDm = new InterfaceDemo();
        intDm.interfaceImplementDemo();
    }
    //接口实现, 用MamalInt实现Animal
    public void interfaceImplementDemo() {
        MamalInt m = new MamalInt();
        m.eat();
        m.travel();
    }
    //接口多继承, 见下方

}

/*
Animal接口
 */
interface AnimalInt {
    public void eat();

    public void travel();
}

/*
Animal接口实现
 */
class MamalInt implements AnimalInt {
    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }
}

/*
Machine接口
 */
interface MachineInt{

}

/*
RobotAnimal接口, 继承Animal和Machine
 */
interface RobotAnimal extends MachineInt, AnimalInt{

}