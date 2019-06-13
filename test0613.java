package everyDay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2019/6/13
 * Time: 20:43
 * Author: vincent-Dou
 * Description：
 */
public class test0613 {
    public static int getSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 5 == 0 && arr[i] % 2 == 0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }
    public static int getsSum2(int[] arr){
        boolean isOK = true;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 5 == 1){
                if(isOK){
                    sum = sum + arr[i];
                    isOK = false;
                }else {
                    sum = sum - arr[i];
                    isOK = true;
                }
            }
        }
        return sum;
    }
    public static int count(int[] arr){
        int count = 0;
        for(int a : arr){
            if(a % 5 == 2){
                count++;
            }
        }
        return count;
    }
    public static String getAve(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(a % 5 == 3){
                list.add(a);
            }
        }
        int sum = 0;
        for(Integer i : list){
            sum = sum + i;
        }
//        BigDecimal bg = new BigDecimal(sum/list.size());
//        String rs = String.valueOf(bg.divide(BigDecimal.valueOf(1), 1, BigDecimal.ROUND_HALF_UP));
        float rs1 = sum / list.size();
        String temp = String.valueOf(rs1);

        return temp.substring(0,temp.indexOf(".") + 2);
    }
    public static int getMax(int[] arr){
        int temp = 0;
        for(int i : arr){
            if(i > temp  &&  i % 5 == 4){
                temp = i;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
//        String str = "1022.2569";
//        int index = str.indexOf(".");
//        System.out.println(index);
//        System.out.println(str.substring(0,(str.indexOf("."))));

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        int rs1 = getSum(arr);
        int rs2 = getsSum2(arr);
        int rs3 = count(arr);
        String rs4 = getAve(arr);
        int rs5 = getMax(arr);
        System.out.println(rs1+" "+rs2+" "+rs3+" "+rs4+" "+rs5);
    }
}
