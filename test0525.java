package everyDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/25
 * Time: 23:30
 * Description：
 */
public class test0525 {
    public static void main(String[] args){
        String s = " 1 2 3 2 2 2 5 4 2";
        System.out.println(getnum(s));

    }

    public static int getnum(String s){
        String[] strs = s.trim().split(" ");
        List <Integer> arrlist = new ArrayList();
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals(" ")){
                arrlist.add(Integer.parseInt(strs[i]));
            }
        }
        int[] arr = new int[arrlist.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = arrlist.get(i);
        }
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
