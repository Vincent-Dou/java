package leetcodetest;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        if(str.length == 0){
            return 0;
        }
        int max = 1;
        for(int i = 0; i < str.length; i++){
            int temp = 1;
            for(int j = i+1; j < str.length; j++){
                if(str[i] != str[j] && isfake(s, i+1, j+1) == true){
                	temp++;
                }else{
                	break;
                }
            }
            if(temp > max){
                max = temp;
            }
            System.out.println(max);
        }
           return max;
    }
    public static boolean isfake(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}