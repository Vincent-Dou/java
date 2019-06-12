package everyDay;

import java.util.Scanner;

/**
 * Date: 2019/6/12
 * Time: 21:23
 * Author: vincent-Dou
 * Description：
 */
public class test0612 {
    public static String getMessage(String str){
        StringBuffer sb = new StringBuffer();
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i)>= 70 && str.charAt(i) <= 90){
                sb.append((char)(str.charAt(i) - 5));
            }else if(str.charAt(i) >= 65 && str.charAt(i) <=69 ){
                sb.append((char) (str.charAt(i)+21));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getMessage(str));
        scanner.close();
    }
    public static int getTotalCount(int mounthCount){
        if(mounthCount == 1){
            return 2;
        }else if(mounthCount == 2){
            return 3;
        }else if(mounthCount == 3){
            return 4;
        }
        return getTotalCount(mounthCount - 1)+getTotalCount(mounthCount - 2) + getTotalCount(-3)*2;
    }
}
