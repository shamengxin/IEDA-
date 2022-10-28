package com.shamengxin.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Statement支持SQL注入，凡是业务方面要求是需要进行sql语句拼接的必须使用
 * 演示
 */

public class JDBCTest08 {
    public static void main(String[] args) {
        //用户在控制台输入desc就是降序，asc就是升序
        Scanner in=new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.print("请输入：");
        String keyWord=in.nextLine();
        //执行sql
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        //注册驱动
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3、数据库操作对象
            stmt=conn.createStatement();
            //4、执行sql
            String sql="select ename from emp order by ename "+keyWord;
            rs=stmt.executeQuery(sql);
            //5、处理查询结果集
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
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
