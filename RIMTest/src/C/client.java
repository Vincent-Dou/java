package C;
/**
 * 此类中客户端连接服务端的代理
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import S.SevFun;

public class client {
	public SevFun sevfun;
	public void startclien() throws MalformedURLException, RemoteException, NotBoundException {
		sevfun =  (SevFun) Naming.lookup("rmi://localhost:1998/severfun");
		Scanner input = new Scanner(System.in);
		int ID = 0;
//		System.out.println("请输入登录名：");
//		int ID = input.nextInt();
////		input.close();
//		System.out.println("请输入密码：");
////		Scanner input1 = new Scanner(System.in);
//		int key = input.nextInt();
//		System.out.println(sevfun.checkpassword(ID, key));
		while(true)
		{
			int choice = 0;
			System.out.println("输入0退出游戏\n输入1登录游戏\n输入2用户注册");
			choice = input.nextInt();
			if(choice == 0) {
				System.out.println("你选择退出了游戏~~~");
				break;
			}
			else if(choice == 1) {
				while(true) {
					System.out.println("请输入登录名：");
					ID = input.nextInt();
					System.out.println("请输入密码：");
					String  key = input.next();
					if (sevfun.checkpassword(ID, key) ) {
						System.out.println("登录成功！");
						break;
					}
					else {
						System.out.println("用户名或密码错误请重新输入！！！");
					}
				}
				
				while(true) {
					System.out.println("输入0开始游戏\n输入1查询前十\n输入2查询得分\n输入3返回登录界面");
					int choice1 = input.nextInt();
					if(choice1 == 0) {
						int gamearr[] = sevfun.startGame();//在此处获得一个随机数组；
						System.out.print(gamearr[1]+"\t"+gamearr[2]+"\t"+gamearr[3]+"\t"+gamearr[0]+"\n");
						Dingshi tes = new Dingshi();
//					    tes.start();
					    System.out.println("请输入你的表达式(输入**可以认输)：");
					    String exper = input.next();
					    if(exper.equals("**")) {
					    	System.out.println("你该交智商税了，扣一分");
					    	sevfun.genxing(ID, -1);
					    	continue;
					    }
					    if(c_check.checkinput(exper, gamearr)) {        //在这里判断用户输入的合法性
	//					    System.out.println("传服务端");
						    if(sevfun.checkresult(exper) == 24.0) {
						    	System.out.println("你的结果正确加一分");
						    	sevfun.genxing(ID, 1);
						    }
						    else {
						    	System.out.println(exper+"="+sevfun.checkresult(exper));
						    	System.out.println("你的计算或表达式有错!!!");
						    }
					    }else
					    {
					    	System.out.println("你输入的表达式中没有用到或多用了某些数！!！");
					    }
					}
					else if(choice1 == 1) {
						int arrID[] = sevfun.checkIDqianshi();
						int arrSC[] = sevfun.checkScoreqianshi();
						for(int i = 0,j = 1 ; i < 10; i++,j++)
							{
							System.out.print("第"+j+"名："+arrID[i]+"\t\t得分："+arrSC[i]+"\n");
							}
					}
					else if (choice1 == 3) {
							break;
					}
					else if (choice1 == 2) {
						int playerscore = sevfun.chaxun(ID);
						System.out.println("你当前的得分为："+playerscore);
					}
					else {
						System.out.println("你的输入有错误，请重新输入");
						continue ;
					}
					
				}
			}
	
			else if(choice == 2) {
				while(true) {	
					System.out.println("请输入你想要的账号仅为数字");
					int id = input.nextInt();
					System.out.println("请输入你的密码：");
					String key = input.next();
					if(sevfun.zhuce(id, key) == 1) {
						System.out.println("注册成功");
						break;
					}
					}
				}
			else {
				System.out.println("你的输入有误请重新输入：");
			}
		}
	}
		
		

//		int arr2[] = sevfun.checkIDqianshi();
//		int arr3[] = sevfun.checkScoreqianshi();
//		for(int i = 0,j = 1 ; i <10; i++,j++)
//			{
//			System.out.print("第"+j+"名："+arr2[i]+"\t\t得分："+arr3[i]+"\n");
//			}
		
		
//		int arr1[][] = sevfun.chaxunqianshi();
//		for(int i = 0; i < 5; i++) {
//		System.out.print(arr1[i][0]);
//		System.out.println(arr1[i][1]);
//	}
	
	
	
	public static void main(String[] args) {
		client cilen = new client();
		try {
			cilen.startclien();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
