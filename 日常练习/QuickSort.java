package InBit.sort;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/28
 * Time: 20:21
 * Description：
 */

import java.util.Random;

/**
 * 时间复杂度： nlog2n
 * 空间复杂度： log2n
 * 稳定性： 不稳定
 *
 */
public class QuickSort {
    public static void main(String[] agrs){
        int[] arr = {25,35,1,20,11,75,32,20,1,3};
        display(arr);
        quickSort(arr,0, arr.length - 1);
        display(arr);
    }

    public  static void display(int[] arr){
        for(int i : arr){
            System.out.printf(i + ",");
        }
        System.out.println();
    }
    public static void quickSort(int[] arr, int low, int hig){
        if(low >= hig){
            return ;
        }
        int i = low;
        int j = hig;
        int temp = arr[low];
        while (i < j){
            while (i < j && arr[j] >= temp){
                j--;
            }
            while (i < j && arr[i] <= temp){
                i++;
            }
            if(i < j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
            arr[low] = arr[i];
            arr[i] = temp;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, hig);
    }
}
