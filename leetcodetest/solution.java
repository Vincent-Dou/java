package leetcodetest;
import java.lang.Math;
/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
 */
public class solution {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
	public static int reverse(int x) {
		if(x < -Math.pow(2, 31) || x > Math.pow(2, 31)-1) {
			return 0;
		}
		if(x < 0 && x >= -Math.pow(2, 31)) {
			int arr[] = null;
			int i = 0;
			x = x * -1;
			while(x < 10) {
				arr[i] = x%10;
				x = x/10;
				i++;
			}
			int len = arr.length - 1;
			int returnum = 0;
			for(int j = 0; j < arr.length; j++) {
				returnum = returnum +(int) (arr[j] * Math.pow(10, len));
				len--;
			}
			return returnum*-1;
		}
		if(x == 0) {
			return 0;
		}
		if(x > 0 && x <= Math.pow(2, 31) - 1) {
			int[] arr = null;
			int i = 0;
			x = x * -1;
//			while(x < 10) {
//				arr[i] = x%10;
//				x = x/10;
//				i++;
//			}
			for(i = 0; x < 10; i++) {
				arr[i] = x % 10;
				x = (int)x / 10;
			}
			int len = arr.length - 1;
			int returnum = 0;
			for(int j = 0; j < arr.length; j++) {
				returnum = returnum +(int) (arr[j] * Math.pow(10, len));
				len--;
			}
			return returnum*-1;
		}
		return 0;
	}
}
