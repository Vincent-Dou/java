package Testsomthing;

import java.io.*;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/8
 * Time: 21:24
 * Description：用来统计java源代码的详细信息
 */
public class CalcJavaCode {

    public static int fileNum = 0;//.java文件的数量
    public static int codeLineSum = 0;//java文件中行数总和
    public static int codeNote = 0;//java文件中代码的注释行数
    public static int nullWhiteLine = 0;//java文件中空白的行数


    public static void main(String[] args) throws IOException {
        String pathName = "C:\\Users\\xxx\\Desktop\\java";
        File file = new File(pathName);
        getInformation(file);
        display();
    }

    public static void display(){
        System.out.println("====================================");
        System.err.println("共有"+fileNum+"个java源文件");
        System.err.println("总行数"+codeLineSum);
        System.out.println("代码行数"+(codeLineSum - codeNote)+"\t\t"+"占比"+(double)(codeLineSum - codeNote)/codeLineSum);
        System.out.println("注释行数"+ codeNote+"\t\t"+"占比"+((double)codeNote/codeLineSum));
        System.out.println("空白行"+ nullWhiteLine);
        System.out.println("===================================");
    }


    public static void getInformation(File file) throws IOException {
        if (!file.exists()){
            return ;
        }
        if (file.isFile()){
            String fileName = file.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if(suffix.equals("java")) {
                fileNum++;
                int start = codeLineSum;
                getSingleFileInformation(file);
                int end = codeLineSum;
                System.out.println(file + "\t\t\t" + (end - start));
            }
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1 : files){
                getInformation(file1);
            }
        }
    }


    public static void getSingleFileInformation(File file) throws IOException {
        if(file.exists() && file.isFile()){
//            String fileName = file.getName();
//            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//            if(suffix.equals("java")) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    codeLineSum++;
                    if(str.trim().startsWith("//")){
                        codeNote++;
                    }
                    if(str.trim().equals("")){
                        nullWhiteLine++;
                    }
                    if(str.trim().startsWith("*")){
                        codeNote++;
                    }
                }
            }
//        }
    }
}
