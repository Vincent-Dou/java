package Testsomthing;

import java.io.*;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/20
 * Time: 16:31
 * Description：
 */
public class IOforBlog {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\豆光耀\\Desktop\\tstIO.txt");

//        String str = "thisisatestfotjava.java.java";
//        int i = str.lastIndexOf(".");
//        String substring = str.substring(i+1);
//        System.out.println(substring);

//        Reader reader  = new FileReader(file);
//        char[] data = new char[4];
//        int len;
//        String str = "";
//        String temp = "";
//        while ((len = reader.read(data)) != -1){
//            temp = new String(data, 0, len);
//            str = str + temp;
//        }
//        System.out.println(str);




//        File file1 = new File("C:\\Users\\豆光耀\\Desktop\\test.mp4");
//        file1.createNewFile();
//        long start =  System.currentTimeMillis();
//        copy(file,file1);
//        long end = System.currentTimeMillis();
//        //拷贝结束，共用时+23190ms
//        System.out.println("拷贝结束，共用时+"+(end - start)+"ms");

//        Writer writer = new FileWriter(file,true);
//        writer.write("这是一个测试字符输入流");
//        writer.flush();




//        InputStream inputStream = new FileInputStream(file);
//        byte[] data = new byte[1024];
//        int len = inputStream.read(data);
//        System.out.println("len = "+ len);
//        String  str = new String(data, 0, len);
//        System.out.println(str);
//        System.out.println(str.length());

//        OutputStream outputStream = new FileOutputStream(file,true);
//        outputStream.write("hello world\n".getBytes());
//        String str = "zhis"
//        outputStream.close();
//        InputStream inputStream = new FileInputStream(file);

//        getFilecount(file);
//        System.out.println(count);
//        if(!file.getParentFile().exists()){
//            System.out.println("改文件的父路径不存在");
//            File file1 = file.getParentFile();
//            file1.mkdirs();
//            System.out.println("成功创建文件的父目录");
//            file.createNewFile();
//            System.out.println("成功创建文件");
//        }
//        File file1 = file.getParentFile();
//        System.out.println(file.length());
//        System.out.println(new Date(file.lastModified()));
//        boolean newFile = file.createNewFile();
//        System.out.println(newFile);
//        if(file.exists()){
//            file.delete();
//            System.out.println("删除已创建的文件");
//        }else {
//            boolean b = file.createNewFile();
//            System.out.println(b+"成功创建不存在的文件");
//        }
//        boolean mkdirs = file.mkdirs();
//        System.out.println(mkdirs);
//        String path = file.getPath();
//        String parentPath = file.getParent();
//        System.out.println(path);
//        System.out.println(parentPath);
//        boolean delete = file1.delete();
//        System.out.println(file1.exists());
//        System.out.println(delete);
//        if(!file.exists()){
//            System.out.println(file.mkdirs()+"创建不存在的文件夹");
//        }
    }

    public static int count = 0;
    public static void getFilecount(File file){
        if(!file.exists()){
            return ;
        }
        if(file.isFile()){
            count++;
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1: files){
                getFilecount(file1);
            }
        }
    }
    public static void fileCopy(File file1, File file2) throws IOException {
        if(!file1.exists()){
            throw new IllegalArgumentException("非法输入");
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[4096];
        int len;
        while ((len = inputStream.read(data)) != -1){
            outputStream.write(data,0,len);
        }
    }
}
