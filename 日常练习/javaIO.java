package testInBit;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/7
 * Time: 19:56
 * Description：
 */

import java.io.File;
import java.lang.reflect.Field;

/**
 * File ： 是唯一一个与文件本身（创建 删除 取得文件信息）相关的操作
 *         File类既可以描述文件也可以描述文件夹
 * IOException: 受查异常
 * public File(String pathname) 文件可以不存在根据文件路径产生file对象
 * 创建新文件:
 *      createNewFile()
 * 删除文件：
 *      delete()
 * 判断文件是否存在
 *      exist()
 * 分隔符常量
 *      File.separator
 */
public class javaIO {
    public static void main(String[] args){
        File file = new File("E:\\");
        getFileList(file);
    }
    public static void getFileList(File file){
        if(file == null){
            return ;
        }
        if(file.isFile()){
            System.out.println(file);
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1 : files){
                if(file1.isFile()){
                    System.out.println(file1);
                }else{
                    getFileList(file1);
                }
            }
        }
    }
}
