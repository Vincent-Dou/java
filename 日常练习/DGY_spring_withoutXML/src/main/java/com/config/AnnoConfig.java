package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Date: 2019/6/25
 * Time: 14:12
 * Author: vincent-Dou
 * Description：
 */
@ComponentScan(value = "com.dgy")
@Configuration
public class AnnoConfig {

    @Bean(name = "qr")
//    @Scope(value = "prototype")
    public QueryRunner getQr(DataSource ds){
        return new QueryRunner(ds);
    }
    @Bean(name = "ds")
    public DataSource getDs() throws PropertyVetoException {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setUser("root");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/vincenttest?serverTimezone=GMT");
            ds.setPassword("dgy2275517033");
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            return ds;
    }
}
