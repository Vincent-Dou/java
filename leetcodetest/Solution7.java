package leetcodetest;
/*
官方题解
提交记录
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */

public class Solution7 {
	public static void main(String[] args) {
		String[] str = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(str));
	}
	public static int getsmalllen(String[] str) {
        if(str == null || str.length == 0){
            return 0;
        }else{
		char[] st0 = str[0].toCharArray();
		int len = st0.length;
		int flag = 0;
		for(int i = 1; i < str.length; i++) {
			char[] st = str[i].toCharArray();
			if(len > st.length) {
				flag = i ;
				len = st.length;
			}
		}
		return len;
        }
	}
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return "";
        }
        int len = getsmalllen(strs);
        String s = new String("");
        for(int i = 0; i < len; i++) {
            if(issame(strs,i) == false){
                return s;
            }
        	if(issame(strs, i) == true) {
        		s = s + strs[0].charAt(i);
        	}
        	System.out.println(s);
        }
    	return s;
    }
    public static boolean issame(String[] str,int local){
    	char temp = str[0].charAt(local);
    	boolean result = true;
    	for(int i = 1; i < str.length; i++) {
    		if(temp != str[i].charAt(local)) {
    			result = false;
    		}
    	}
//    	System.out.println(result);
        return result;
    }
 }