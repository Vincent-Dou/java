package leetcodetest;
/*
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class solution1 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
	public static boolean isPalindrome(int x) {
		int flag = x ;
		double num = 0;
		if(x < 0) {
			return false;
		}
		if(x == 0) {
			return true;
		}
		if(x > 0) {
			int[] arr = null;
			for(int i = 0; x < 10; i++) {
				arr[i] = x % 10;
				x = x / 10;
			}
			int len = arr.length - 1;
			for(int i = 0; len >= 0; i++,len--) {
				num =num + Math.pow(10, len)*arr[i];
			}
		}
		if(flag == num) {
			return true;
		}else {
			return false;
		}
    }
}
