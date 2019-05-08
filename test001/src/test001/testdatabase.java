package test001;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testdatabase {

	public static void main(String[] args) {

		try {
			String sql = "SELECT * FROM vincenttest.Student\r\n"+
		"order by Sage ASC\r\n";
//		con = test01.getconnection();
			Statement sta = test01.getconnection().createStatement();
			ResultSet rs = sta.executeQuery(sql);
			String a = null ;
			String b = null ;
			String c = null ;
			String d = null ;
			String e = null ;
			while(rs.next()){
				a = rs.getString("Sno");
				b = rs.getString("Sname");
				c = rs.getString("Ssex");
				d = rs.getString("Sage");
				e = rs.getString("Sdept");
			System.out.println(a+"\t"+b +"\t"+c+"\t"+d+"\t"+e);			            
			}
			rs.close();
//		con.close();
			sta.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
