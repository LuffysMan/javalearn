/*
@java方法基本同c++函数, 有细微不同, 比如
@可变参数: 在方法声明中，在指定参数类型后加一个省略号(...).
一个方法中只能指定一个可变参数, 它必须是方法的最后一个参数.任何普通的参数必须在它之前声明.
@finalize()方法
Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。
例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。
在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。

 */
public class Method {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
        //finalize()方法
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);
        c2 = c3 = null;
        System.gc(); //调用Java垃圾收集器
    }
    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}


class Cake extends Object {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + "is disposed");
    }
}