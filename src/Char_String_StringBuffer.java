import java.lang.*;
public class Char_String_StringBuffer {
    public static void main(String[] args){
        CharTest cT = new CharTest();
        StringTest sT = new StringTest();
        StringBufferTest sBT = new StringBufferTest();
        cT.test();
        sT.test();
        sBT.test();
    }
}
/*******Character类提供了一系列方法来操纵字符 ***********/
class CharTest{
    private Character cH;
    public CharTest(){
        cH = '6';
    }
    public void test(){
        System.out.println("Character类测试: "+ this.cH);
        System.out.println("isDigit: "+Character.isDigit(this.cH));
        System.out.println("isWhitespace: "+Character.isWhitespace(this.cH));
        System.out.println("toString: "+Character.toString(this.cH));

    }
}


class StringTest{
    private String str;

    public StringTest() {
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        str = String.valueOf(helloArray);
    }
    public void test(){
        System.out.println("String类测试: "+ this.str);
        String str1 = new String("runoob");
        String str2 = new String("salary");
        //连接字符串
        str1 = str2.concat("cainiao");
        str1 = str1 + str2;
        //格式化字符串
        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", 1.0, 1, 123);

        String fs;
        fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", 1.0, 1, 123);
        //String 方法, 很多
        System.out.println();
    }

}

/*
Java StringBuffer 和 StringBuilder 类

当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。

和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。

StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。

由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，
则必须使用 StringBuffer 类。
 */
class StringBufferTest{
    private StringBuffer strBuf;

    public StringBufferTest() {
        strBuf = new StringBuffer("StringBuffer类测试: ");
    }
    public void test(){
        System.out.println(this.strBuf);
        this.strBuf.append("runoob");
        System.out.println(this.strBuf);
    }

}


