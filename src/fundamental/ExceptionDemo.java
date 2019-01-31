/*
@java 异常处理
异常发生的原因有很多，通常包含以下几大类：
    用户输入了非法数据。
    要打开的文件不存在。
    网络通信时连接中断，或者JVM内存溢出。
三种类型的异常：
    检查性异常: 最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。
    运行时异常: 运行时异常是可能被程序员避免的异常.
    错误: 错误不是异常，而是脱离程序员控制的问题.
Exception类: IOExcption子类, RuntimeException子类
@检查性异常, 也即IO异常, 必须用try/catch代码块处理, 否则编译器出错

@非检查性异常, runtime异常, 编译器不管, 由jvm接管
数组访问越界

@声明自定义异常
在 Java 中你可以自定义异常。编写自己的异常类时需要记住下面的几点。
    所有异常都必须是 Throwable 的子类。
    如果希望写一个检查性异常类，则需要继承 Exception 类。
    如果你想写一个运行时异常类，那么需要继承 RuntimeException 类。

 */
import org.omg.CORBA.INITIALIZE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

public class ExceptionDemo {
    public static void main(String[] args) {
        ExceptionDemo expDm = new ExceptionDemo();
//        expDm.singleCatch();
//        expDm.multiCatch("./out/sdf.txt");
//        expDm.throwDemo();
//        expDm.finallyDemo();
        expDm.myExcetion();

    }

    //单个catch块
    public void singleCatch() {
        try {
            int[] a = new int[2];
            System.out.println("access elment three" + a[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown: " + e);
        }
        System.out.println("Out of block");
    }

    //多重catch块
    public int multiCatch(String fileName) {

        try {
            FileInputStream file = new FileInputStream(fileName);
            byte x = (byte) file.read();
        }
        catch(FileNotFoundException f) { // Not valid!
            f.printStackTrace();
            return -1;
        } catch(IOException i) {
            i.printStackTrace();
            return -1;
        }
        return 1;
    }

    //throws/throw 关键字, 可抛出单个或多个异常, 用逗号隔开
    public void throwDemo() throws InsufficientFundsException, RemoteException{
        // Method implementation
    }

    //finally关键字, 无论是否发生异常，finally 代码块中的代码总会被执行。
    public void finallyDemo() {
        int a[] = new int[2];
        try{
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }
        finally{
            a[0] = 6;
            System.out.println("First element value: " +a[0]);
            System.out.println("The finally statement is executed");
        }
    }

    //自定义异常类
    public void myExcetion() {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500);
        try {
            System.out.println("\nWithdrawing $100...");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $" + e.getAmount());
            e.printStackTrace();
        }
    }
}

//自定义异常类
class InsufficientFundsException extends Exception{
    //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
}

//测试类,此类模拟银行账户, 用于测试自定义异常
class CheckingAccount{
    //balance为余额，number为卡号
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    //方法, 存钱
    public void deposit(double amount) {
        this.balance += amount;
    }
    //方法, 取钱
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    //method, 返回余额
    public double getBalance() {
        return balance;
    }

    //method, 返回卡号
    public int getNumber() {
        return number;
    }
}