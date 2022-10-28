package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * sql脚本
 *      drop table if exists t_act;
 *      create table t_act(
 *          actno bigint,
 *          balance double(7,2)//七位有效数字，小数点后两位
 *          );
 *      insert into t_act(actno,balance) values(111,20000);
 *      insert into t_act(actno,balance) values(222,0);
 *      commit;
 *      select * from t_act;
 *
 * 重点三行代码：
 *      conn.setAutoCommit(false);
 *      conn.commit();
 *      conn.rollback();
 */
public class JCBCTest11 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");

            //将自动提交机制修改位手动提交机制
            conn.setAutoCommit(false);

            String sql="update t_act set balance=? where actno=?";
            ps=conn.prepareStatement(sql);

            //传值
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count=ps.executeUpdate();

            //String s=null;
            //s.toCharArray();
            //-------->程序出现错误，账户丢失10000元

            //传值
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count+=ps.executeUpdate();

            //程序能走到这里说明以上程序没有异常，事务结束，手动提交数据
            conn.commit();
            System.out.println(count==2?"转账成功":"转账失败");
        } catch (ClassNotFoundException e) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
