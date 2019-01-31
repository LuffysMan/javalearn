package javaoo;/*
@java 面向对象
@@java继承
java不支持多重继承(与C++不同)
@@java override和overlord
重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常.
声明为static的方法不能被重写,但是能够被再次声明.
@@java多态
多态是同一个行为具有多个不同表现形式或形态的能力.
多态就是同一个接口,使用不同的实例而执行不同操作.
@@java 抽象类
抽象类除了不能实例化对象之外, 类的其它功能依然存在, 成员变量,成员方法和构造方法的访问方式和普通类一样.
由于抽象类不能实例化对象, 所以抽象类必须被继承, 才能被使用. 也是因为这个原因, 通常在设计阶段决定要不要设计抽象类.
抽象类中不一定包含抽象方法, 但是有抽象方法的类必定是抽象类.
抽象类的子类必须给出抽象类中的抽象方法的具体实现, 除非该子类也是抽象类.
@@java封装
通过访问修饰符private, protected来对外隐蔽类的属性和方法
封装的优点
    1. 良好的封装能够减少耦合.
    2. 类内部的结构可以自由修改.
    3. 可以对成员变量进行更精确的控制.
    4. 隐藏信息, 实现细节.
*/

public class ObjectOriented {
    public static void main(String[] args) {
        ObjectOriented oo = new ObjectOriented();
//        oo.overrideDemo();
//        oo.overloadDemo();
//        oo.polymorphismDemo(new javaoo.Cat());
//        oo.polymorphismDemo(new javaoo.Dog());
        oo.abstractDemo();
    }

    //override, java重写
    public void overrideDemo() {
        Animal a = new Animal();
        Animal b = new Dog();
        a.eat();
        b.eat();
//        b.work();     //编译错误, b没有此方法
    }

    //重载(Overload)
    public void overloadDemo() {
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }

    //多态
    public void polymorphismDemo(Animal a /*向上转型:Dog或Cat引用类型转为Animal引用类型*/)  {
        a.eat();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;       //向下转型
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }

    //抽象类
    public void abstractDemo() {
//        javaoo.Employee e = new javaoo.Employee("张三", "曲江", 107);      //编译报错, javaoo.Employee is abstract; cannot be instantiated.
        Salary s = new Salary("张三", "曲江", 107, 0);
        Employee e = new Salary("李四", "浐灞", 108, 10000);      //编译报错, javaoo.Employee is abstract; cannot be instantiated.
        s.mailCheck();
        e.mailCheck();
        e.computePay();     //抽象方法, 由子类实现

    }
}

class Animal{
    public void eat(){}
}

class Dog extends Animal{
    public void eat() {
        System.out.println("吃骨头");
    }
    public void work(){
        System.out.println("看家");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("抓老鼠");
    }
}

class Overloading {
    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a){
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a,String s){
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s,int a){
        System.out.println("test4");
        return "returntest4";
    }

}

/*
抽象类
 */
abstract class Employee
{
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number)
    {
        System.out.println("Constructing an javaoo.Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public abstract double computePay();    //抽象方法, 子类必须实现, 否则子类也须声明为抽象类

    public void mailCheck()
    {
        System.out.println("Mailing a check to " + this.name
                + " " + this.address);
    }
    public String toString()
    {
        return name + " " + address + " " + number;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    public int getNumber()
    {
        return number;
    }
}

class Salary extends Employee
{
    private double salary; //Annual salary
    public Salary(String name, String address, int number, double
            salary)
    {
        super(name, address, number);
        setSalary(salary);
    }
    public void mailCheck()
    {
        System.out.println("Within mailCheck of javaoo.Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double newSalary)
    {
        if(newSalary >= 0.0)
        {
            salary = newSalary;
        }
    }
    public double computePay()
    {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }
}
