package com.zqs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author zhouqianshun
 * @create 2022-11-23 14:00
 * @date 2022/11/23 - 14:00
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:13306/fruitdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "zqs19980315");
        String sql = "insert into t_fruit values(0,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"菠萝");
        ps.setObject(2,"5");
        ps.setObject(3,"100");
        ps.setObject(4,"菠萝便宜卖");
        int update = ps.executeUpdate();
        if(update>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }
}
