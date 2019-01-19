package sort;

public class ShellSort {
	public static void main(String[] args) {
		int arr[] = {2,5,85,1,11,3,0,110};
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
		}
		System.out.println();
		ShellSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
		}
	}
	public static void shellSort(int[] arr) {
        int j = 0;
        int temp = 0;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + "   ");
            System.out.println("");
        }
    }
	public static void ShellSort(int[] arr) {
		int L = arr.length;
		while(true) {
			L = L / 2;
			//arr[i]是一个序列的第一个元素
			for(int i = 0; i < L; i++) {
				//arr[j]是由增量确定的元素
				for(int j = i + L; j < arr.length; j = j+L) {
					int temp = arr[j];//temp是未排序的第一个元素，一个序列的第1个元素（第0个为有序的）
					//以下开始插入排序
					for(int k = j - L; k >= 0; k = k -L ) {
						if(temp > arr[k]) {
							arr[k+L] = temp;
							break;
						}
						if(temp < arr[k]) {
							arr[k+L] = arr[k];
						}
						if(k == i) {
							arr[i] = temp;
							break;
						}
					}
				}
			}
			//如果增量减小到1则排序完成，退出while循环
			if(L == 1) {
				break;
			}
		}
	}
}
