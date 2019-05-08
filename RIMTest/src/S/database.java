package S;
/**
 * 在本类中继承SevFun接口然后对接口中声明的方法重写并实现需求；
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
/**
 * Author ：豆光耀
 * 1 此类封装了根据ID验证数据库密码的方法；
 * 2 对数据库的更新操作；
 * 3 对数据库的数据插入；
 * 4 对数据库中的得分查询；
 * 5 对于数据库中用户信息的删除；
 */
public class database  extends UnicastRemoteObject implements SevFun{
	protected database() throws RemoteException {
		super();
	}
//	public static void main(String[] args) {
////		System.out.println(checkpassword(20181223, "12346"));
////		genxing(20181222, 1);
////		System.out.println(chaxun(20181223));
////		System.out.println(checkpassword(20181223, "123456"));
////		System.out.println(shanchu(20153));
//		int arr[][] = chaxunqianshi();
//		for(int i = 0; i < 5; i++) {
//			System.out.print(arr[i][0]);
//			System.out.println(arr[i][1]);
//		}
//		chaxunqianshi();
//	}
	//验证密码：
	public boolean checkpassword(int idnum,String  pas)
	{
		String password = " ";
		String sql = "select Password from Vincenttest.kcsj where ID = '"+idnum+"'";
		try {
			Statement sta = test01.getconnection().createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()){
				password = rs.getString("Password");  //在次数根据ID获取相应的密码；
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
												//在此数将输入的密码与数据库中得密码进行比较
		if(pas.equals(password))			
		{
			return true ;
		}
		else
		{
			return false ;
		}

	}
	
	//此方法用来更新数据
	public int genxing(int idnum,int sco)
	{
		int scor = chaxun(idnum) + sco ;
		int i = 0;  //用于判断sql语句的执行 
		String sql = "UPDATE vincenttest.kcsj set Score = '"+scor+"' where ID = '"+idnum+"'";
		try {
			Connection conn = test01.getconnection();
			Statement sta = conn.createStatement();
			i = sta.executeUpdate(sql);//执行成功 i = 1 ；
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i ;
	}
	//此方法用于数据的插入用户注册
	public int zhuce(int idnum, String pas)
	{
		int sco = 0 ;
		int i = 0;
		String sql = "insert into vincenttest.kcsj (ID,Password,Score) Values('"+idnum+"','"+pas+"','"+sco+"')";
		try {
			Connection conn = test01.getconnection();
			Statement sta = conn.createStatement();
			i = sta.executeUpdate(sql); //执行成功 i = 1 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//此方法用于对分数的查询
	public int chaxun(int idnum)
	{
		int sco = 0 ;
		String sql = "select Score from Vincenttest.kcsj where ID = '"+idnum+"'";
		try {
			Statement sta = test01.getconnection().createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()){
				sco = rs.getInt("Score");  //在此处获取相应的分数；
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sco;
	}
	//此方法用于注销用户；
	public int shanchu(int idnum)
	{
		int i = 0 ; // 用于判断sql语句的执行效果；
		String sql = "DELETE from vincenttest.kcsj where ID = '"+idnum+"'";
		try {
			Connection conn = test01.getconnection();
			Statement sta =  conn.createStatement();
			i = sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i ;     //执行成功返回1；
	}
		
	//此方法用来实现游戏的数字生成
	public  int[] startGame()
	{
		int arr[] = {0,0,0,0};
		arr = game24.startGame();
		return arr;
	}
	
	//此方法用来检验字符串的数学表达式的计算
	public double checkresult(String str)
	{
		double daan = 0 ;
		daan = Calculator.conversion(str);
		return daan;
	}
	//此方法用来查询前十名
	public  int [][] chaxunqianshi()
	{
		int i = 1 ;
		int a = 0;
		int b = 0;
		int arr[][] = null ;
		String sql = "SELECT ID,Score FROM vincenttest.kcsj order by Score DESC";
		try {
			Connection conn = test01.getconnection();
			Statement sta = conn.createStatement();
			ResultSet rs =  sta.executeQuery(sql);
//			String e = null ;
//			while(rs.next()){
//				a = rs.getString("ID");
//				b = rs.getString("Password");
//				c = rs.getString("Score");

			while(rs.next())
			{
				arr[i][0]= rs.getInt("ID");
				arr[i][1]= rs.getInt("Score");
//				System.out.println("第"+i+"名："+a[i][0]+"\t"+"得分为："+b);
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	//查询前十的ID
	public int [] checkIDqianshi() {
		int arr[] = {0,0,0,0,0,0,0,0,0,0} ;
		int i = 0 ;
		String sql = "SELECT ID FROM vincenttest.kcsj order by Score DESC";
		try {
			Connection conn = test01.getconnection();
			Statement sta = conn.createStatement();
			ResultSet rs =  sta.executeQuery(sql);
			while(rs.next()) {
				arr[i] = rs.getInt("ID");
				i++;
				if(i==10)
				{
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr ;
	}
	//查询前十的成绩(Score)
	public int [] checkScoreqianshi()
	{
		int arr[] = {0,0,0,0,0,0,0,0,0,0} ;
		int i = 0 ;
		String sql = "SELECT Score FROM vincenttest.kcsj order by Score DESC";
		try {
			Connection conn = test01.getconnection();
			Statement sta = conn.createStatement();
			ResultSet rs =  sta.executeQuery(sql);
			while(rs.next()) {
				arr[i] = rs.getInt("Score");
				i++;
				if(i==10)
				{
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr ;
	}
}
