package com.shamengxin.jdbc.utils;

import java.sql.*;

/**
 * JDBC工具类，简化JDBC编程
 */
public class DBUtil {
    /**
     * 工具类中的构造方法都是私有的。
     * 因为工具类的方法都是静态的，不需要new对象，直接采用类名调用。
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
     * 获取数据库连接对象
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
    }

    /**
     * 关闭资源
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集
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
