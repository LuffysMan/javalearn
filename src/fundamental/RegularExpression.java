import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/*
@java正则表达式
正则表达式定义了字符串的模式.
正则表达式可以用来搜索、编辑或处理文本.
@java.util.regex 包主要包括以下三个类：
    Pattern 类：
    pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
    Matcher 类：
    Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
    PatternSyntaxException：
    PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
 */
public class RegularExpression {
    public static void main(String[] args){
        RegularExpression rex = new RegularExpression();
        rex.matchDemo();
        rex.groupDemo();
        rex.regexMatch();
        rex.match_lookingAt();
        rex.replaceAll();
        rex.appendReplacement();
        rex.checkQQ("294q2942942");
    }
    //Pattern类match方法
    public void matchDemo(){
        String content = "I am a noob from runoob.com";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
    //捕获组
    public void groupDemo(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\d)(\\D*)(\\d+)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println("组数: "+m.groupCount());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
            System.out.println("Found value: " + m.group(4) );

        } else {
            System.out.println("NO MATCH");
        }
    }
    //Mather类方法
    public static void regexMatch(){
        final String REGEX = "\\bcat\\b";
        final String INPUT = "12cat cat cat catti2e cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
    //matches 和 lookingAt 方法
    public void match_lookingAt(){
        final String REGEX = "foo";
        final String INPUT = "foo ooooooooooooooo";
        final String INPUT2 = "ooooo foo oooooooooo";
        Pattern pattern;
        Matcher matcher;
        Matcher matcher2;

        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
        System.out.println("Current INPUT2 is: "+INPUT2);

        System.out.println("matches(): "+matcher.matches());
        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("lookingAt(): "+matcher2.lookingAt());
    }
    //replace和replaceAll
    public void replaceAll(){
        String REGEX = "dog";
        String INPUT = "The dog says meow. " +
                "All dogs say meow.";
        String REPLACE = "cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        System.out.println(m.replaceAll(REPLACE));
    }
    //appendReplacement 和 appendTail 方法
    public void appendReplacement(){
        String REGEX = "f*b";
        String INPUT = "aabooaabffffboofoobkkk";
        //String INPUT = "b";
        String REPLACE = "-";
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
       m.appendTail(sb);
        System.out.println(sb.toString());
    }
    //1. 给定的字符串是否符合正则表达式的过滤逻辑（称作"匹配"）;
    // 2. 可以通过正则表达式，从字符串中获取我们想要的特定部分.
    //检查qq号,要求：必须是5~15位数字，0不能开头.
    public void checkQQ(String qq)
    {
        String reg = "[1-9][0-9]{4,14}";
        System.out.println(qq.matches(reg)?"合法qq":"非法qq");
    }

}

