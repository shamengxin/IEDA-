package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement���insert delete update
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
           /*��� insert
           String sql="insert into dept(deptno,dname,loc) values (?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,60);
            ps.setString(2,"���۲�");
            ps.setString(3,"�Ϻ�");*/

            /*�޸� update
            String sql="update dept set dname=?,loc=? where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"�ͷ���");
            ps.setString(2,"�人");
            ps.setInt(3,60); */

            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,50);

            int count=ps.executeUpdate();
            System.out.println(count==1?"��ӳɹ�":"���ʧ��");
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
