package sort2;

public class QuickSort {
	public static void main(String[] args) {
		int [] arr = {9,8,7,6,54,4,3,2,1,0};
		sort(arr, 0, arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}
//	public static void quicksort(int[] arr,int low,int hig) {
//		int temp = arr[0];
//		low = 0;
//		hig = arr.length -1;
//		while(low < hig) {
//			while(arr[hig] <= temp && low < hig) {
//				hig--;
//			}
//			while(arr[low] >= temp && low < hig) {
//				low--;
//			}
//			if(low < hig) {
//				int t = arr[low];
//				arr[low] = arr[hig];
//				arr[hig] = t;
//			}
//		}
//		arr[0] = arr[low];
//		arr[low] = temp;
//		quicksort(arr,0,hig-1);
//		quicksort(arr, low+1, hig);
//	}
	  public static void QuickSort(int[] arr, int low, int high){
	        int i,j,temp,t;
	        if(low>high){
	            return;
	        }
	        i=low;
	        j=high;
	        //temp就是基准位
	        temp = arr[low];
	 
	        while (i<j) {
	            //先看右边，依次往左递减
	            while (temp<=arr[j]&&i<j) {
	                j--;
	            }
	            //再看左边，依次往右递增
	            while (temp>=arr[i]&&i<j) {
	                i++;
	            }
	            //如果满足条件则交换
	            if (i<j) {
	                t = arr[j];
	                arr[j] = arr[i];
	                arr[i] = t;
	            }
	 
	        }
	        //最后将基准为与i和j相等位置的数字交换
	         arr[low] = arr[i];
	         arr[i] = temp;
	        //递归调用左半数组
	         QuickSort(arr, low, j-1);
	        //递归调用右半数组
	         QuickSort(arr, j+1, high);
	    }
	  public static void sort(int[] arr, int low , int hig) {
		  //判断是否应该继续
		  if(low > hig) {
			  return;
		  }
		  int temp = arr[low];
		  int i = low;
		  int j = hig;
		  //判断是否相遇
		  while(i < j) {
			  //从右往左遍历找小于基准数的数
			  while(i < j && temp <= arr[j]) {
				  j--;
			  }
			  //从左往右遍历找大于基准数的数
			  while(i < j && temp >= arr[i]) {
				  i++;
			  }
			  //如果没有相遇那么就将找出的两个数进行交换
			  if(i < j) {
				  int temp2 = arr[i];
				  arr[i] = arr[j];
				  arr[j] = temp2;
			  }
		  }
		  //相遇后，将基准数与相遇位置的数进行交换
		  arr[low] = arr[j];
		  arr[j] = temp;
		  //从左边继续递归
		  sort(arr,low,i-1);
		  //从右边继续递归
		  sort(arr,i+1,hig);
	  }
	}