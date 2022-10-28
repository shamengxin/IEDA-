package com.shamengxin.jdbc;

import com.shamengxin.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���������һ�������������ר�Ž��в�ѯ������ʹ���м���/����������ס��ؼ�¼��
 */
public class JDBCTest13 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            //��������
            conn.setAutoCommit(false);

            String sql="select ename,sal from emp where job=? for update ";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"manager");

            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getDouble("sal"));
            }
            //�ύ�������������
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
            DBUtil.close(conn,ps,rs);
        }
    }
}
