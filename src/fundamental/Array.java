/**************java数组************************/
/*
数组声明
dataType[] arrayRefVar = new dataType[arraySize];
dataType[] arrayRefVar = {value0, value1, ..., valuek};
//java中一切皆对象, 数组也是, 可以有数组成员  array.length
 */
import java.util.Arrays;
public class Array {
    int[] nAry1 = new int[10];
    int[] nAry2 = new int[10];
    public static void main(String[] args) {
        Array ary = new Array();
        ary.arrayDeclare();
    }
    //数组声明
    public void arrayDeclare() {
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        // 打印所有数组元素
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);
        // 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);
    }
    //多维数组
    public void multiDimArray(){
        //直接为每一维分配空间
        String str[][] = new String[3][4];
        //必须指定最高维, 低维可以动态分配
        String s[][] = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");
    }
    //数组访问
    public void arrayAccess(){
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        // for each 打印所有数组元素
        for (double element: myList) {
            System.out.println(element);
        }
    }
    //java.util.Arrays提供静态方法操作数组
    public void optArray(){
        Arrays.fill(nAry1, 0);  //填充
        Arrays.fill(nAry2, 2);
        Arrays.sort(nAry2);         //排序
        Arrays.equals(nAry2, nAry1); // 比较
        int idx = Arrays.binarySearch(nAry2, 2); //二分查找
    }

}
