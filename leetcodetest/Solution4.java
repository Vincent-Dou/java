package leetcodetest;

import java.util.Arrays;

public class Solution4 {
	public static void main(String[] args) {
		String str = "asaassafhoiuguie";
		String str2 = longestPalindrome(str);
		System.out.println(str2);
		String str3 = "hoiuguie";
		char[] str4 = str3.toCharArray();
		System.out.println(ishuiwen(str4, 2, 6));
	}
	    public static String longestPalindrome(String s) {
	        char str[] = s.toCharArray();
	        int maxlen = 1;
	        int star = 0;
	        int end = 0;
	        for(int i = 0; i < str.length; i++) {
	        	for(int j = i+1; j < str.length; j++) {
	        		if(ishuiwen(str, i, j) && (j-i+1) > maxlen ) {
	        			maxlen = j-i+1;
	        			star = i;
	        			end = j;
	        		}
	        	}
	        }
	        char[] str2 = new char[maxlen];
	        for(int i = 0; i < maxlen; i++) {
	        	str2[i] = str[star];
	        	star++;
	        }
	         return new String(str2);
	    }
	    public static boolean ishuiwen(char[] str,int start,int end){
	      boolean flag = true;
	        for(int i = start;i<str.length/2 && end > 0;i++){
	            if(str[i]!= str[end]){
	                flag = false;
	            }
	             start++;
	             end--;
	        }
	        return flag;
	    }
	}