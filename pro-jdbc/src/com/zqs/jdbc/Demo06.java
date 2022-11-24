package com.zqs.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author zhouqianshun
 * @create 2022-11-23 17:04
 * @date 2022/11/23 - 17:04
 */
public class Demo06 {
    public static void main(String[] args) throws Exception {
        Connection conn = jdbcUtils.getConnection();
        String sql = "select count(*) from t_fruit";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            int count  = resultSet.getInt(1);
            System.out.println(count);
        }


    }
}
