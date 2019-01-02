package S;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 服务端绑定
 * @author 豆光耀
 *
 */
public class Sever {
		SevFun severefun;
		public void ser() throws RemoteException, MalformedURLException, AlreadyBoundException {
			severefun = new database();
			LocateRegistry.createRegistry(1998);
			Naming.bind("rmi://localhost:1998/severfun",severefun);
			System.out.println("服务端:对象绑定成功！");
		}
		public static void main(String[] args) {
			try {
				Sever sever = new Sever();
				sever.ser();
				while(true);
			} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
				e.printStackTrace();
			}
		}
}
