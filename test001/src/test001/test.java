package test001;

public class test
{
public static void main(String[] args) {
	
	int i= 0;
	int j= 0;
	for (i=0 ;i<7;i++)
		{
			for(j=0; j<13; j++)
			{
				if(j<=6+i&&j>=6-i)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
					if (j==12) {
						System.out.println("");
					}
				}
			}
		}

	for (i=0 ; i<6; i++) {        
		System.out.print("\n"+" ");
		for(j=0; j<11; j++) {
			if(j>=i&&j<=10-i) {
				System.out.print("*");
			}
			
			else
			{
				System.out.print(" ");
			}
		}
	}
	
	}
}





	