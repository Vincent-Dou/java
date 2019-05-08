package sort3;


public class HeapSort{
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] arr = {55,3,21,58,9,101,43,19,27};
		System.out.println("排序前：");
		for(int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i]+"  ");
		}
		heapSort(arr);
		System.out.println("\n排序后:");
		for(int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i]+"  ");
		}
		long end = System.nanoTime();
		System.out.println("\n排序用时："+(end - start)+"ns");
	}
	public static void heapSort(int[] arr) {
		//将待排序序列初始化成堆
		for(int i = arr.length / 2; i >= 0; i--) {
			HeapAdjust(arr, i, arr.length-1);
		}
		//开始排序
		for(int i = arr.length - 1, temp = 0; i > 0; i--) {
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			HeapAdjust(arr, 0, i);
		}
	}
	//对堆进行调整
	public static void HeapAdjust(int[] arr, int parent, int len) {
		//记录父节点的值
		int temp = arr[parent];
		//寻找左孩子节点
		int child = 2 * parent + 1;
		while(child < len) {
			//从左孩子和右孩子节点中选取较大的
			if(child + 1 < len && arr[child+1] > arr[child]) {
				child ++;
			}
			//如果父节点大于两个孩子节点，则不用交换
			if(arr[parent] > arr[child]) {
				break;
			}
			//将父节点与较大的子节点进行交换
			arr[parent] = arr[child];
			parent = child;
			child = 2 * child + 1;
		}
		arr[parent] = temp;
	}
	
}