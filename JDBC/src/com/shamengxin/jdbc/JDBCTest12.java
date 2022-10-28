package com.shamengxin.jdbc;

import com.shamengxin.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1������DBUtil
 * 2��ģ����ѯ��ôд
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //��ȡ����
            conn= DBUtil.getConnection();
            //��ȡ���ݿ��������
            //����д��
            /*String sql="select ename from emp where ename like '_?%'";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"A");*/

            String sql="select ename from emp where ename like ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"_A%");
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //�ͷ���Դ
            DBUtil.close(conn,ps,rs);
        }

    }
}
