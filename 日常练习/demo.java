import java.io.File;

public class demo {
    public static int filecount = 0;
    public static int Dircount = 0;
    public static void main(String[] args) {
        File file = new File("///home/douguangyao/Desktop/");
//        System.out.println(file.isDirectory());
////        System.out.println(file);
//        File[] files = file.listFiles();
//        for(File temp : files){
//            System.out.println(temp);
//        }
        int[] a = getFile(file);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(Dircount);
        System.out.println(filecount);
    }

    public static int[] getFile(File file){
        int[] arr = new int[2];
        if(!file.exists()){
            return arr;
        }
        if(file.isFile()){
            filecount++;
            arr[0] = filecount;
//            System.out.println(count);
            System.out.println(file);
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for(File temp : files){
                if(temp.isDirectory()){
                    Dircount++;
                    arr[1] = Dircount;
                    getFile(temp);
                }else{
                    filecount++;
                    arr[0] = filecount;
                    System.out.println(temp);
                }
            }
        }
        return arr;
    }
}
