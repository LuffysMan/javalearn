import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/***************java Number&Math类*****************/
/*
Java 语言为每一个内置数据类型提供了对应的包装类.
Number类属于java.lang包.
 */
public class Number_Math {
    public static void main(String[] args){
        Number_Math nm = new Number_Math();
        nm.mathTest();
        nm.numberTest();
    }
    public void numberTest(){
        System.out.println("Number类测试");
        Integer nAge = Integer.valueOf(27);     //返回27的Integer实例
        System.out.println("byteValue: "+nAge.byteValue());
        System.out.println("toString" + nAge.toString());
    }
    public void mathTest(){
        System.out.println("Math类测试");
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);
        System.out.println("下取整x=5.2: "+ Math.floor(5.2));
        System.out.println("上取整x=5.2: "+ Math.ceil(5.2));
        System.out.println("四舍五入x=5.2: "+ Math.round(5.2));
        System.out.println("四舍五入x=5.2: "+ Math.rint(5.2));

    }
}
