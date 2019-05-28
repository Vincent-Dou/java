package everyDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/27
 * Time: 20:54
 * Description：
 */
public class test0527 {
    public static void main(String[] args){
        //long sta = System.currentTimeMillis();
        int[] arrt = {0,1,2,3,4,5,6,7};
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        int len = arr.length;
        int size = arr.length;
        List<Integer> arr1 = new ArrayList<>();
        int index = 0;
        for(int i = 0; i >=0; i= i+2){
            if(!arr1.contains(arr[i % len])){
                arr1.add(i%len);
                index = i % len;
                size--;
            }else{
                continue;
            }
            if(size == 0){
                break;
            }
        }
        System.out.println(index);
//        getLastNumIndex1(arr);
        //long end = System.currentTimeMillis();
        //System.out.println(end - sta);
//        String s = "3 9 6 8 -10 7 -11 19 30 12 23 5";
//        int[] arr = getMin(s);
//        for(int i : arr){
//            System.out.println(i);
//        }
    }
    public static int getLastNumIndex(int[] arr){
        int len = arr.length;
        int size = arr.length;
        List<Integer> arr1 = new ArrayList<>();
        int index = 0;
        for(int i = 0; i >=0; i= i+2){
            if(!arr1.contains(arr[i % len])){
                arr1.add(i%len);
                index = i % len;
                size--;
            }else{
                continue;
            }
            if(size == 0){
                break;
            }
        }
        return index;
    }
    public static int[] getMin(String s){
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        String[] strs = s.trim().split(" ");
        int num = Integer.valueOf(strs[strs.length - 1]);
        int[] arr = new int[strs.length - 1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.valueOf(strs[i]);
        }
        Arrays.sort(arr);
        int[] temp = new int[num];
        System.arraycopy(arr,0,temp,0,num);
        return temp;
    }

    public static void getLastNumIndex1(int[] arr){
        int len = arr.length;
        int right = len;
        int e = len % 3;
        int v = len;
//        System.out.println(arr[len - 1 - e]);
        while (arr[len - 1 - e] != (len - 1)){
            arr[len - 1 - e] = -1;
            right = right - e;
            v = right + e;
            e = v % 3;
            int i = e;
            while(arr[len - 1 - e] == -1){
                e ++;
            }
            System.out.println(arr[len - 1 - e]);
            e = i;
        }
    }
}


