package InBit.sort;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/21
 * Time: 16:50
 * Description： 希尔排序(是直接插入排序的优化) 
 */
public class ShellSort {
    public static void main(String[] agrs){
        int[] arr = {9,5,25,31,20,55,33};
        display(arr);
        shellSort(arr);
        display(arr);

    }

    public static void display(int[] arr){
        for(int i : arr){
            System.out.print(i + " , ");
        }
        System.out.println();
    }

    public static void shell(int[] array, int gap) {
        int distence = gap;
        for(int i = distence; i < array.length; i++){
            int temp  = array[i];
            for(int j = i - distence; j >= 0; j = j - distence){
                if(temp >= array[j]){
                    break;
                }
                array[j+distence] = array[j];
                if(temp < array[j]){
                    array[j] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
}
