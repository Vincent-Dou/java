package S;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * 此类用于生成4个随机数
 */
import java.util.Random;

public class game24 {

	public  static int[] startGame()
	{
		int arr[] = {0,0,0,0};
		int i = 0 ;
		while(i <= 3) {
			int num = ((int)(Math.random()*9)+1);
			if(num != arr[1] && num!=arr[2] &&num!=arr[0] && num!=arr[3])
			{
			arr[i] = num ;
			i ++ ;
			}
			else
			{
				continue;
			}
		}
		return arr;
	}
//	public static void main(String[] args) {
//		int arr[] = startGame();
//		for(int i = 0; i < arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
//	}
}
