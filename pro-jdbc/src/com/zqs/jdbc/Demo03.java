package com.zqs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zhouqianshun
 * @create 2022-11-23 15:37
 * @date 2022/11/23 - 15:37
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Fruit fruit = new Fruit(7,"猕猴桃","猕猴桃是水果之王");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:13306/fruitdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "zqs19980315");
        String sql = "update t_fruit set fname = ? ,remark = ? where fid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,fruit.getName());
        ps.setString(2,fruit.getRemark());
        ps.setInt(3,fruit.getFid());
        int update = ps.executeUpdate();

    }

}
