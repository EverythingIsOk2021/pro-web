package com.zqs.fruit.dao.impl;

import com.zqs.fruit.dao.FruitDAO;
import com.zqs.fruit.pojo.Fruit;
import com.zqs.fruit.utils.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouqianshun
 * @create 2022-11-23 20:03
 * @date 2022/11/23 - 20:03
 */
public class FruitDAOImpl implements FruitDAO {
    @Override
    public List<Fruit>  getFruitList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "select * from t_fruit";
            ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
            ArrayList<Fruit> list = new ArrayList<>();
            while(rs.next()){
                int fid = rs.getInt(1);
                String fname = rs.getString("fname");
                int price = rs.getInt(3);
                int fcount = rs.getInt(4);
                String remark = rs.getString("remark");
                Fruit fruit = new Fruit(fid,fname,price,fcount,remark);
                list.add(fruit);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            jdbcUtils.Close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "insert into t_fruit values(0,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,fruit.getFname());
            ps.setInt(2,fruit.getPrice());
            ps.setInt(3,fruit.getFcount());
            ps.setString(4,fruit.getRemark());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(conn,ps);
        }
            return false;
    }

    @Override
    public Fruit getFruitByName(String fname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "select * from t_fruit where fname like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,fname);
            rs = ps.executeQuery();
            if(rs.next()){
                return new Fruit(rs.getInt(1),rs.getString("fname"),rs.getInt(3),rs.getInt(4),rs.getString("remark"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "update t_fruit set fname = ?,fcount = ?, price = ?,remark = ? ";
            ps= conn.prepareStatement(sql);
            ps.setString(1,fruit.getFname());
            ps.setInt(2,fruit.getFcount());
            ps.setInt(3,fruit.getPrice());
            ps.setString(4,fruit.getRemark());
           return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(conn,ps);
        }
        return false;
    }

    @Override
    public boolean delFruit(String fname) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "delete from t_fruit where fname like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,fname);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(conn,ps);
        }
        return false;
    }
}
