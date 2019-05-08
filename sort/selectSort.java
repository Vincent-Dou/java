package sort;

public class selectSort {

    public static void main(String[] args) {
        int arr1[] = {5,9,6,7,0,5,14,2,1};
        slectSort(arr1);
        for(int i = 0; i < arr1.length; i++) {
            System.out.println("第"+i+"是："+arr1[i]);
        }
    }
    public static void slectSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            //找出最小的数的角标
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j ;
                }
            }
            //将最小的数与未排序序列的第一个元素交换位置
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                System.out.print("第"+i+"次排序：");
    			for(int i1 = 0 ; i1 <arr.length; i1++ ) {
    				System.out.print(arr[i1]+" ");
    			}
    			System.out.println("");
        }
    }
}
