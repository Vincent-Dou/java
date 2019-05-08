package leetcodetest;

public class Solution6 {
	public static void main(String[] args) {
		int i = romanToInt("IVVVMCDL");
		System.out.println(i);
	}
    public static int romanToInt(String s) {
        small(s);
        char str[] = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < str.length; i++){
            String tem = "";
            if(i+1<str.length){
        	    tem = str[i]+""+str[i+1];
            }
        	if(small(tem) != 0) {
        		sum = sum + small(tem);
        		i++;
        	}else {
            if(str[i] == 'I'){
                sum = sum + 1;
            }
            if(str[i] == 'V'){
                sum = sum + 5;
            } 
            if(str[i] == 'X'){
                sum = sum + 10;
            }
            if(str[i] == 'L'){
                sum = sum + 50;
            }
            if(str[i] == 'C'){
                sum = sum + 100;
            }
            if(str[i] == 'D'){
                sum = sum + 500;
            }
            if(str[i] == 'M'){
                sum = sum + 1000;
            }
        }
        }
        return sum;
    }
    public static int small(String s){
        if(s.equals("IV")){
            return 4;
        }
        if(s.equals("IX")){
            return 9;
        }
        if(s.equals("XL")){
            return 40;
        }
        if(s.equals("XC")){
            return 90;
        }
        if(s.equals("CD")){
            return 400;
        }
        if(s.equals("CM")){
            return 900;
        }
        return 0;
    }
}

