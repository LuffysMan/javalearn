/*
@java Stream(流), file和IO
@java IO 流主要包括字节流和字符流两大类
 */
import java.io.*;

public class IOStream {
    public static void main(String[] args) throws Exception {
        IOStream ios = new IOStream();
//        ios.readDemo();
//        ios.readLineDemo();
//        ios.writeDemo();
//        ios.fileStreamDemo();
//        ios.fileStreamDemo2();
//        ios.createDirs();
//        ios.readDir();
//        ios.deleteFolder(new File("./out/test"));
        ios.musicCompound();
    }

    //从控制台读取多字符输入, 使用 BufferedReader 的 read() 方法
    public void readDemo() throws Exception {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下q键退出");
        //读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    //从控制台读取字符串, 使用 BufferedReader 的 readLine() 方法
    public void readLineDemo() throws Exception {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }

    //控制台输出, 制台的输出由 print() println()成.这些方法都由类 PrintStream 定义, System.out 是该类对象的一个引用.
    public void writeDemo() {
        int b;
        b = 'A';
        System.out.write('A');
        System.out.write('\n');
    }

    //读写文件, 以二进制读写, 有乱码, 是由于输入输出格式转换的原因, 和字符集编码方式无关
    public void fileStreamDemo() {
        try {
            byte[] bWrite = {11, 22, 127, 12, 21};
            OutputStream os = new FileOutputStream("./out/test.txt");
            for (int x = 0; x < bWrite.length; ++x) {
                os.write(bWrite[x]);
            }
            os.close();
            InputStream is = new FileInputStream("./out/test.txt");
            int size = is.available();
            for (int x = 0; x < size; ++x) {
                System.out.print((byte) is.read() + " ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    //读写文件, 保持字符集编码格式一致
    public void fileStreamDemo2() throws Exception {
        File f = new File("./out/test2.txt");
        // 构建FileOutputStream对象,文件不存在会自动新建
        FileOutputStream fop = new FileOutputStream(f);
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        //写到缓冲区
        writer.append("中文输入");
        writer.append("\r\n");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
        writer.append("English");
        // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
        writer.close();
        // 关闭输出流,释放系统资源
        fop.close();

        // 构建FileInputStream对象
        FileInputStream fip = new FileInputStream(f);
        // 构建InputStreamReader对象,编码与写入相同
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());    //转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();
    }

    //java中的目录, 创建目录
    public void createDirs() {
        String dir = "./out/test";
        File f = new File(dir);
        f.mkdirs();             //创建目录, 连同路径上的父文件夹一块创建
    }

    //读取目录
    public void readDir() {
        String dir = "./out";
        File f = new File(dir);
        if (f.isDirectory()) {
            System.out.println("目录: " + dir);
            String[] fLst = f.list();
            for (int i = 0; i < fLst.length; ++i) {
                File fTmp = new File(dir + "/" + fLst[i]);
                if (fTmp.isDirectory()) {
                    System.out.println("是一个目录: " + fLst[i]);
                } else {
                    System.out.println("不是一个目录: " + fLst[i]);
                }
            }
        } else {
            System.out.println("不是一个目录: " + dir);
        }
    }

    //删除目录或文件
    public void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File eachfile : files) {
                if (eachfile.isDirectory()) {
                    deleteFolder(eachfile);
                } else {
                    eachfile.delete();
                    System.out.println("delete file: " + eachfile.toString());
                }
            }
        }
        folder.delete();
    }

    //音频混剪, 使用FileInputStream和FileOutputStream
    public void musicCompound() {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String fileNames[] = {"./out/test/星月神话.mp3","./out/test/我只在乎你.mp3"};
        //设置byte数组，每次往输出流中传入8K的内容
        byte by[] = new byte[1024*8];
        try
        {
            fos = new FileOutputStream("./out/test/合并.mp3");
            for(int i=0;i<2;i++)
            {
                int count = 0;
                fis = new FileInputStream(fileNames[i]);
                //跳过前面3M的歌曲内容
                fis.skip(1024*1024*3);
                while(fis.read(by) != -1)
                {
                    fos.write(by);
                    count++;
                    System.out.println(count);
                    //要截取中间2MB的内容，每次输入8k的内容，所以输入的次数是1024*2/8
                    if(count == (1024*2/8))
                    {
                        break;
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //输出完成后关闭输入输出流
                fis.close();
                fos.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
