package everyDay;

/**
 * Auther:vincent-Dou
 * Date: 2019/6/2
 * Time: 17:54
 * Description：
 */
public class test0602 {
    public static void main(String[] args) {
//        String a = "hello";
//        String b = "he" + new String("llo");
//        String c = "hello";
//        System.out.println(a == c);
//        System.out.println(a == b);
//        test();
//        Byte a =  10;
//        add(a);
//        System.out.println(a);
//        int[] a = 5;
//        int b = 10;
//        change(a , b);
//        System.out.println(a + " "+ b);
//        int[] arr1 = {1,2,3,4,5,6,7,8,9};
//        int[] arr2 = new int[5];
//        System.arraycopy(arr1,4,arr2,0,arr2.length);
//        for(int i : arr2){
//            System.out.println(i);
//        }


//
//        int[] a = {1,2,3};
//        int[] b = {7,8,9};
//        change2(a, b);
//        for(int i : a){
//            System.out.println(i);
//        }
//        for(int i : b){
//            System.out.println(i);
//        }
//        int a = 9;
//        System.out.println(a >> 1);
//        int a = 49;
//        String s = "10101010101";
//        char b = '0';
//        char c = '0';
//        System.out.println(b ^ c);
        String[] strings = getGray(9);
        for(String i : strings){
            System.out.println(i);
        }
    }
    public static String[] getGray(int n) {
        String strs = Integer.toBinaryString(n);
        StringBuffer sb = new StringBuffer();
        for(int i = strs.length() - 1; i > 0; i--){
            if(isFirst(strs, i)){
                break;
            }
            sb.append(strs.charAt(i) ^ strs.charAt(i-1));
        }
        sb.append(strs.charAt(0));
        String temp = sb.reverse().toString();
        if(temp.length() < n + 1){
            String tmp = "";
            for(int i = 0; i < (n - temp.length() + 1); i++){
                tmp = tmp + "0";
            }
            temp = tmp + temp;
        }
        String[] strings = new String[temp.length()];
        for(int i = 0; i < temp.length(); i++){
            strings[i] = String.valueOf(temp.charAt(i));
        }
        return strings;
    }
    public static boolean isFirst(String s, int n){
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
    public static int[] changetwo(int[] AB){
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }
    public static  void change2(int[] arr1, int[] arr2){
//        arr1[0] = 115;
        int[] temp = new int[arr1.length];
        System.arraycopy(arr1,0,temp,0,arr1.length);
        System.arraycopy(arr2,0,arr1,0,arr1.length);
        System.arraycopy(temp,0,arr2,0,temp.length);
//        for(int i : arr2){
//            System.out.println(i);
//        }
    }
    public static void change(int a , int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static  void  add(Byte b){
        b = ++b;
        System.out.println(b);
    }
    public static void test(){
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a);
        add(b);
        System.out.println(b);
    }
}
