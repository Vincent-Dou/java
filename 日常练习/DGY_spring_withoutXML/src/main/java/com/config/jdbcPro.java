package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Date: 2019/6/25
 * Time: 19:18
 * Author: vincent-Dou
 * Description：
 */
public class jdbcPro {
    @Value("${user}")
    private String user;

    @Value("${password}")
    private String passeword;

    @Value("${url}")
    private String url;

    @Value("${driver}")
    private String driver;


    @Bean(name = "qr")
    @Scope(value = "prototype")
    public QueryRunner getQr(DataSource ds){
        return new QueryRunner(ds);
    }
    
    @Bean(name = "ds")
    public DataSource getDs() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(user);
        ds.setJdbcUrl(url);
        ds.setPassword(passeword);
        ds.setDriverClass(driver);
        return ds;
    }
}
