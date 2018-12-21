package test001;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;



public class TCPtest {
	//客户端
	@Test
	public void client(){
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getLocalHost(),8980);
			os = socket.getOutputStream();
			Scanner input = new Scanner(System.in);
			String input1 = null ;
			//使用户可以一直选择直到用户退出；
			int input2 = 1;
			while (input2 != 2)
			{
			System.out.println("---------------->选择0开始游戏"+"\n"+"---------------->选择1查询前十"+"\n"+"---------------->选择2退出程序");
			input1 = input.nextLine();
			input2 = Integer.parseInt(input1);
			//在此处判断用户的选择
			if (input1.equals("0"))
			{
			//在此处开始游戏
				numbergame gam = new numbergame();
				gam.game();
			}
			else if(input1.equals("1"))
			{
			os.write(input1.getBytes());
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[120];
			int len;
			while((len = is.read(b)) != -1){	
				String str = new String(b,0,len);
				System.out.println(str);
			}
			}
			else
			{
				System.out.println("你的输入有误，请重新输入");
				input1 = input.nextLine();
				input2 = Integer.parseInt(input1);
			}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	//服务端
	@Test
	public void server(){
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(8980);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[120];
			int len;
			String str = null ;
			while((len = is.read(b)) != -1){
				str = new String(b,0,len);
				System.out.print(str);
			}
			if (str.equals("1"))
			{
			os = s.getOutputStream();
			String sql = "SELECT * FROM vincenttest.student\r\n"+
					"order by Sage ASC\r\n";
			try {
				String sql1 = "SELECT * FROM vincenttest.student\r\n"+
			"order by Sage ASC\r\n";
				Statement sta = test01.getconnection().createStatement();
				ResultSet rs = sta.executeQuery(sql1);
				String a = null ;
				String b1 = null ;
				String c = null ;
				String d = null ;
				String e = null ;
				int i=0;
				String[] array=new String[10];
				while(rs.next()){
					a = rs.getString("Sno");
					b1 = rs.getString("Sname");
					array[i++]=b1;
					c = rs.getString("Ssex");
					d = rs.getString("Sage");
					e = rs.getString("Sdept");
				}
				rs.close();
				sta.close();
				try {
					for(int i1 = 0; i1 < 4; i1++)
					{
						os.write(array[i1].getBytes());
						Thread.sleep(1000);
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(is != null){ 
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}