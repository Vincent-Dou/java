package KCSJ;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;

public class TCPtest {
//	public static void main(final String[] args) {
//		try {
//			final InetAddress testip = InetAddress.getLocalHost();
//			System.out.println(testip);
//			System.out.println(testip.getHostAddress());
//			System.out.println(testip.getHostName());
//		} catch (final UnknownHostException e) {
//			e.printStackTrace();
//		}
//	}
	@Test
	public void client() 
		{
			Socket socket = null ;
			OutputStream os = null ;
				try {
					socket = new Socket(InetAddress.getLocalHost(),9090);
					os = socket.getOutputStream();
					os.write("我是客户端".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					if(os != null){
						try {
							os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (socket != null)
					{
						try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		}
	

	@Test
	public void sever()
	{
		ServerSocket sever = null;
		Socket socket = null ;
		InputStream Is = null ;
		
		try {
			sever = new ServerSocket(9090);
			socket = sever.accept();
			Is = socket.getInputStream();
			System.out.println(sever.getInetAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(Is != null)
			{
				try {
					Is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null)
			{
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sever != null)
			{
				try {
					sever.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
}
