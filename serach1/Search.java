package serach1;

public class Search {
	public static void main(String[] args) {
//		int arr[] = {12,3,5,4,8,89,1,5,7,5,3,1,54,58};
		int arr[] = {1,2,3,4,6,7,8,9};
		if(binsearch(arr, 5)) {
			System.out.println("存在");
		}else {
			System.out.println("不存在");
		}
	}
	//顺序查找
	public static boolean seqsearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return true;
			}
		}
		return false;
	}
	//折半查找
	public static boolean binsearch(int arr[], int key) {
		int low = 0;
		int hig = arr.length-1;
		while(low <= hig) {
			int mid = (low + hig) / 2;
			//在左半部分
			if(arr[mid] > key) {
				hig = mid - 1;
			}
			//在右半部分
			if(arr[mid] < key){
				low = mid + 1;
			}
			//存在
			if(arr[mid] == key) {
				return true;
			}
		}
		//不存在
		return false;
	}	
}
