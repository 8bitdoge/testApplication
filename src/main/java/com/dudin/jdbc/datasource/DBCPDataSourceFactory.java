package com.dudin.jdbc.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceFactory {

    public DataSource getDataSource(String dbType) {
        BasicDataSource ds = new BasicDataSource();

        if ("mysql".equals(dbType)) {
            ds.setDriverClassName("org.mariadb.jdbc.Driver");
            ds.setUrl("jdbc:mariadb://localhost:3306/testapplication");
            ds.setUsername("root");
            ds.setPassword("********");
        } else {
            return null;
        }

        return ds;
    }
}