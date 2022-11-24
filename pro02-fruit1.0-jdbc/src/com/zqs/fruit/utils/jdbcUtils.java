package com.zqs.fruit.utils;

import java.io.InputStream;
import java.sql.*;
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
        Connection connection = DriverManager.getConnection(url, user, password);
        return (Connection) connection;
    }
    public static void Close(Connection conn, PreparedStatement ps, ResultSet rs){
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null)
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public static void Close(Connection conn, PreparedStatement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
             }
        }
}
