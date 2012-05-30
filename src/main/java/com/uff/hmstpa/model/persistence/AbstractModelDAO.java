package com.uff.hmstpa.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class AbstractModelDAO {
    
    private static File databasePropertyFile = new File("./config/database.properties");
    protected JdbcTemplate jdbcTemplate;
    private DriverManagerDataSource dataSource;

    protected AbstractModelDAO() {
        init();
    }
    
    private void init() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(databasePropertyFile));
            dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(props.getProperty("driver"));
            dataSource.setUrl(props.getProperty("url"));
            dataSource.setUsername(props.getProperty("username"));
            dataSource.setPassword(props.getProperty("password"));
            
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
