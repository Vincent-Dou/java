package everyDay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/26
 * Time: 21:54
 * Description：求最小公倍数
 */
public class test0526 {
    public static void main(String[] args){
        System.out.println(getMinNum(50, 20));
    }
    public static int getMinNum(int a, int b){
        List<Integer> arr1 = new ArrayList();
        List<Integer> arr2 = new ArrayList();
        for(int i = 1; i <= b; i++){
            arr1.add( i * a);
        }
        for(int i = 0; i <= a; i++){
            arr2.add(i * b);
        }
        Iterator <Integer> iterator = arr1.iterator();
        while (iterator.hasNext()){
            int temp = iterator.next();
            if(arr2.contains(temp)){
                return temp;
            }
        }
        return a*b;
    }
}
