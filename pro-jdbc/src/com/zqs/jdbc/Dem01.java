package com.zqs.jdbc;

import sun.security.util.Password;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author zhouqianshun
 * @create 2022-11-21 15:41
 * @date 2022/11/21 - 15:41
 */
public class Dem01 {

    public static void main(String[] args) throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //通过驱动管理器链接对象
        String url = "jdbc:mysql://localhost:13306/fruitdb";
        String user = "root";
        String password = "zqs1998";
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

}
