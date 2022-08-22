package com.ems.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ConnectionFactory {
    @Resource
    private static DataSource dataSource;

    public static void setDataSource(DataSource dataSource) {
        ConnectionFactory.dataSource = dataSource;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}