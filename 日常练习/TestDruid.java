import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Date: 2019/6/10
 * Time: 17:42
 * Author: vincent-Dou
 * Description：
 */
public class TestDruid {
    public static void main(String[] args) throws Exception {

//        Properties properties = new Properties();
//        TestDruid.class.getClassLoader().getResourceAsStream("");


        InputStream resourceAsStream = TestDruid.class.getClassLoader().getResourceAsStream("druid.properties");
        DruidDataSource ds = null;
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);



//        DruidDataSource ds=new DruidDataSource();
//        //1基本参数4个
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/vincenttest?serverTimezone=GMT");
//        ds.setUsername("root");
//        ds.setPassword("dgy2275517033");
//
//        //2其他配置
//        //2.1设置初始大小
//        ds.setInitialSize(20);
//        //2.2设置最大大小
//        ds.setMaxActive(50);
//        //2.3设置最小空闲连接
//        ds.setMinIdle(5);
//        //2.4设置等待时间
//        ds.setMaxWait(1000);

        // 测试连接是否正常
        for(int i=0;i<100;i++) {
            Connection conn=ds.getConnection();
            System.out.println(conn.getClass().getName()+"..."+i);
            conn.close();
        }

        String sql = "select Password from Vincenttest.kcsj where ID = 1215";
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String result = " ";
        while (rs.next()){
            result = rs.getString("Password");
        }
        System.out.println(result);
    }
}
