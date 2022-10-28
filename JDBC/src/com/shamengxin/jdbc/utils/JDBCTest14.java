package com.shamengxin.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����������޸ı������ļ�¼
 */
public class JDBCTest14 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="update emp set sal=sal*1.1 where job=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"manager");
            int count=ps.executeUpdate();
            System.out.println(count);
            conn.commit();
        } catch (SQLException throwables) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }
}
