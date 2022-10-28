package com.shamengxin.jdbc.utils;

import java.sql.*;

/**
 * JDBC�����࣬��JDBC���
 */
public class DBUtil {
    /**
     * �������еĹ��췽������˽�еġ�
     * ��Ϊ������ķ������Ǿ�̬�ģ�����Ҫnew����ֱ�Ӳ����������á�
     */
    private DBUtil(){ }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ����Ӷ���
     * @return ���Ӷ���
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
    }

    /**
     * �ر���Դ
     * @param conn ���Ӷ���
     * @param ps ���ݿ��������
     * @param rs �����
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
