package leetcodetest;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class Solution5 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(232));
	}
    public static boolean isPalindrome(int x) {
    	if(x < 0 || (x%10==0) && x!=0) {
    		return false;
    	}
    	if(x < 10) {
    		return true;
    	}
        String str = String.valueOf(x);
        final StringBuilder builder = new StringBuilder(str);
        if(builder.reverse().toString().equals(str)){
            return true;
        }
        return false;
    }
}
