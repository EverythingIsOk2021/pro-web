package com.zqs.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author zhouqianshun
 * @create 2022-11-23 16:20
 * @date 2022/11/23 - 16:20
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        Connection conn = jdbcUtils.getConnection();
        String sql = "select * from t_fruit where fid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet rs = ps.executeQuery();
        ArrayList<Fruit> list = new ArrayList<>();

        while(rs.next()){
            int fid = rs.getInt(1);
            String fname = rs.getString("fname");
            int fcount = rs.getInt(3);
            int price = rs.getInt(4);
            String remark = rs.getString("remark");
            Fruit fruit = new Fruit(fid,fname,fcount,price,remark);
            System.out.println(fruit);
        }

    }
}
