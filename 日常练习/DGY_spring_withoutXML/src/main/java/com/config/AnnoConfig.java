package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Date: 2019/6/25
 * Time: 14:12
 * Author: vincent-Dou
 * Description：
 */
@ComponentScan(value = "com.dgy")
@Import(jdbcPro.class)
@PropertySource("springAnno.properties")
public class AnnoConfig {

}
