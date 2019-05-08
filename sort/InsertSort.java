package sort;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {9,5,7,11,13,2,55,1};
		for(int i1 = 0 ; i1 <arr.length; i1++ ) {
			System.out.print(arr[i1]+" ");
		}
		System.out.println("");
		inSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("第"+i+"个："+arr[i]);
		}
	}
	//从第二个开始
	//划分出已经排序和未排序的部分
	//选中未排序中的第一个元素
	//与已经排序的部分从后往前比较若小于则将排序好的往后移
	//若大于已经近排好序的某数则在该数的后面插入
	public static void inSort(int arr[]) {
		for(int i = 1 ; i < arr.length; i++) {
			//arr[i]是未排序序列的第一个元素
			int temp = arr[i];
			//arr[j]是已经排序好的序列的最后一个 
			for(int j = i - 1; j >= 0; j-- ) {
				//如果大于一个元素，那么插入到它的后面
				if(temp > arr[j]) {
					arr[j+1] = temp;
					break;
				}
				//如果arr[i]小于已排好的最后一个，将已经排好的序列后移一位
				if(temp < arr[j]) {
					arr[j+1] = arr[j];
				}
				//当对比到数组的第0个元素时，说明它自己就是最小的
				if(j == 0) {
					arr[0] = temp;
					break;
				}
			}
			System.out.print("第"+i+"次排序：");
			for(int i1 = 0 ; i1 <arr.length; i1++ ) {
				System.out.print(arr[i1]+" ");
			}
			System.out.println("");
		}
	}
}
