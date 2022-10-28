package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务机制：
 *      1、JDBC中的事务是自动提交的，什么是自动提交？
 *          只要执行任意一条DML语句，则自动提交一次。这是JDBC默认的事务行为。
 *          但是在实际的业务中，通常都是N条DML语句共同联合才能完成的，必须保
 *          证他们这些DML语句在同一个事务中同时成功或者同时失败。
 *      2、以下程序先来验证以下 JDBC的事务是否是自动提交机制！
 *          测试结果：JDBC中只要执行任意一条DML语句，就提交一次。
 */
public class JDBCTest10 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");

            String sql="update dept set dname=? where deptno=?";
            ps=conn.prepareStatement(sql);

            //第一次占位符传值
            ps.setString(1,"客服部");
            ps.setInt(2,20);
            int count=ps.executeUpdate();
            System.out.println(count==1?"添加成功":"添加失败");

            //第二次给占位符传值
            ps.setString(1,"客服部");
            ps.setInt(2,30);
            count=ps.executeUpdate();
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
