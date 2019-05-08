package InBit.sort;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/21
 * Time: 15:40
 * Description：插入排序；
 * 时间复杂度： n^2,如果是有序的数据，那么时间复杂度是 n   ,越有序越快
 * 空间复杂度 O(1)
 * 稳定性 ： 稳定的
 *
 */
public class InsertSort {
    public static void main(String[] agrs){
        int[] arr = {8,9,2,4,6,87,25,63};
        display(arr);
        insertSort(arr);
        display(arr);
    }

    public static void display(int[] arr){
        for(int i : arr){
            System.out.print(i + " , ");
        }
        System.out.println();
    }
    public static void insertSort(int[] arr){
        if (arr.length <= 1) {
            return ;
        }
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            for(int j = i - 1; j >= 0; j--){
                if(temp >= arr[j]){
                    break;
                }
                arr[j+1] = arr[j];
                if(temp < arr[j]){
                    arr[j] = temp;
                }
            }
        }
    }
}
