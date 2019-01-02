package S;
/**
 * 将服务端需要的方法封装在本接口中；
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SevFun extends Remote {	
	public boolean checkpassword(int idnum,String key) throws RemoteException;
	public int genxing(int idnum,int sco) throws RemoteException;
	public int zhuce(int idnum, String pas) throws RemoteException;
	public int chaxun(int idnum) throws RemoteException;
	public int shanchu(int idnum) throws RemoteException;
	public int[] startGame() throws RemoteException;
	public double checkresult(String str) throws RemoteException;
	public int[][] chaxunqianshi() throws RemoteException ;
	public int [] checkIDqianshi() throws RemoteException ;
	public int [] checkScoreqianshi() throws RemoteException;
}
