package everyDay;

import edu.princeton.cs.algs4.In;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Date: 2019/6/3
 * Time: 21:39
 * Author: vincent-Dou
 * Description：
 */
public class test0603 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] arr = getNum(str);
        StringBuffer sb = new StringBuffer();
        sb.append(getFirst(arr));
        for(int i = 0; i < arr.length - 1; i++){
            int temp = getMin(arr);
            sb.append(temp);
        }
        System.out.println(sb.toString());
    }
    public static int[] getNum(String str){
        String[] strs = str.trim().split(" ");
        int len = 0;
        for(int i = 0; i < strs.length; i++){
            len = len + Integer.parseInt(strs[i]);
        }
        int[] arr = new int[len];
        for(int i = 0, j = 0; i < strs.length; i++){
            int temp = Integer.parseInt(strs[i]);
            while ( temp != 0){
                arr[j] = i;
                j++;
                temp--;
            }
        }
        return arr;
    }
    public static int getMin(int[] arr){
        int temp = 9;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                continue;
            }
            if(temp >= arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        arr[index] = -1;
        return temp;
    }
    public static int getFirst(int[] arr){
        int temp = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                temp = arr[i];
                index = i;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if((arr[i] < temp) && arr[i] != 0){
                temp = arr[i];
                index = i;
            }
        }
        arr[index] = -1;
        return temp;
    }
}
