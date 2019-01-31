/*
@java Scanner类
java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入。
 */
import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args) {
        ScannerDemo scd = new ScannerDemo();
//        scd.ScanNext();
//        scd.ScanNextline();
//        scd.ScanNextNum();
        scd.ScanNextNumEx();
    }

    //使用next方法
    public void ScanNext() {
        Scanner scan = new Scanner(System.in);      // 从键盘接收数据
        System.out.println("next方式接收：");// next方式接收字符串
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

    //使用nextline方法
    public void ScanNextline() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }

    //输入int, double等
    public void ScanNextNum() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }

    public void ScanNextNumEx() {
        Scanner scan = new Scanner(System.in);
        double dIn = 0.0;
        double sum = 0.0;
        int n = 0;
        System.out.println("输入数字求平均, 输入非数字停止");
        while (scan.hasNextDouble()) {
            dIn = scan.nextDouble();
            System.out.println(dIn);
            n += 1;
            sum += dIn;
        }
        System.out.println("sum: "+ sum);
        System.out.println("average: "+ (sum/n));
    }

}
