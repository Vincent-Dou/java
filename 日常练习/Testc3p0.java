import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 2019/6/11
 * Time: 9:45
 * Author: vincent-Dou
 * Description：
 */
public class Testc3p0 {
    public static void main(String[] args) throws SQLException, PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/vincenttest?serverTimezone=GMT");
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setUser("root");
        ds.setPassword("dgy2275517033");
        ds.setInitialPoolSize(20);
        ds.setMaxAdministrativeTaskTime(50);
        ds.setMinPoolSize(5);
        ds.setMaxStatements(1000);
        Connection connection = ds.getConnection();
        String sql = "select Password from Vincenttest.kcsj where ID = 1215";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        System.out.println(connection);
        String result = " ";
        while (rs.next()){
            result = rs.getString("Password");
        }
        System.out.println(result);
    }
}
