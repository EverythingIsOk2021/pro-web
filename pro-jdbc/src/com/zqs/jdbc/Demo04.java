package com.zqs.jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author zhouqianshun
 * @create 2022-11-23 15:58
 * @date 2022/11/23 - 15:58
 */
public class Demo04 {
    public static void main(String[] args)  {

        Connection conn = null;
        ArrayList<Fruit> list = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:13306/fruitdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "zqs19980315");
            String sql = "select * from t_fruit";
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int fid = resultSet.getInt(1);
                String fname = resultSet.getNString("fname");
                int fcount = resultSet.getInt(3);
                int price = resultSet.getInt(4);
                String remark = resultSet.getNString("remark");
                Fruit fruit = new Fruit(fid, fname, fcount, price, remark);
                list.add(fruit);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        list.forEach(System.out::println);

    }
}
