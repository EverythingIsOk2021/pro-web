package com.zqs.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author zhouqianshun
 * @create 2022-11-23 16:21
 * @date 2022/11/23 - 16:21
 */
public class jdbcUtils {
    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties ps = new Properties();
        ps.load(is);
        String user = ps.getProperty("user");
        String password = ps.getProperty("password");
        String url = ps.getProperty("url");
        String driverClass = ps.getProperty("driverClass");
        Class.forName(driverClass);
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        return (Connection) connection;
    }
}
