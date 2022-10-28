package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC������ƣ�
 *      1��JDBC�е��������Զ��ύ�ģ�ʲô���Զ��ύ��
 *          ֻҪִ������һ��DML��䣬���Զ��ύһ�Ρ�����JDBCĬ�ϵ�������Ϊ��
 *          ������ʵ�ʵ�ҵ���У�ͨ������N��DML��乲ͬ���ϲ�����ɵģ����뱣
 *          ֤������ЩDML�����ͬһ��������ͬʱ�ɹ�����ͬʱʧ�ܡ�
 *      2�����³���������֤���� JDBC�������Ƿ����Զ��ύ���ƣ�
 *          ���Խ����JDBC��ֻҪִ������һ��DML��䣬���ύһ�Ρ�
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

            //��һ��ռλ����ֵ
            ps.setString(1,"�ͷ���");
            ps.setInt(2,20);
            int count=ps.executeUpdate();
            System.out.println(count==1?"��ӳɹ�":"���ʧ��");

            //�ڶ��θ�ռλ����ֵ
            ps.setString(1,"�ͷ���");
            ps.setInt(2,30);
            count=ps.executeUpdate();
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
