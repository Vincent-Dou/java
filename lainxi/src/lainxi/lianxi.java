package lainxi;
import java.util.Scanner;

public class lianxi {
	public static void main(String[]args){
		System.out.println("请输入班级人数");
		Scanner input=new Scanner(System.in);
		
		int count =input.nextInt();
		int[] test=new int[count];
		System.out.println("请依次输入学生成绩");
		for(int i=0;i<count;i++)
		{
			//Scanner input1=new Scanner(System.in);
	      int k = input.nextInt();
	      test[i]=k;
		}
		input.close();
         int max =test[0];
         for(int a=0;a<count;a++) {
        	  if(test[a]>test[0])
      	        max =test[a];
         }
         System.out.println("最高成绩为"+max);
        
		for(int j=0;j<count;j++)
		{
            if(test[j]>test[0]) 
	        max =test[j];

			if (test[j]>90) {  
				System.out.println("student"+j+"等级为A"+"成绩为"+test[j]);}
			else {
			System.out.println("student"+j+"等级为B"+"成绩为"+test[j]);
				
}
		
	}
	}
}

