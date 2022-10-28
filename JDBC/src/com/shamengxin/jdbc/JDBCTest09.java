package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement完成insert delete update
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
           /*添加 insert
           String sql="insert into dept(deptno,dname,loc) values (?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,60);
            ps.setString(2,"销售部");
            ps.setString(3,"上海");*/

            /*修改 update
            String sql="update dept set dname=?,loc=? where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"客服部");
            ps.setString(2,"武汉");
            ps.setInt(3,60); */

            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,50);

            int count=ps.executeUpdate();
            System.out.println(count==1?"添加成功":"添加失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
