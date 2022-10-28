package com.shamengxin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * sql�ű�
 *      drop table if exists t_act;
 *      create table t_act(
 *          actno bigint,
 *          balance double(7,2)//��λ��Ч���֣�С�������λ
 *          );
 *      insert into t_act(actno,balance) values(111,20000);
 *      insert into t_act(actno,balance) values(222,0);
 *      commit;
 *      select * from t_act;
 *
 * �ص����д��룺
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

            //���Զ��ύ�����޸�λ�ֶ��ύ����
            conn.setAutoCommit(false);

            String sql="update t_act set balance=? where actno=?";
            ps=conn.prepareStatement(sql);

            //��ֵ
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count=ps.executeUpdate();

            //String s=null;
            //s.toCharArray();
            //-------->������ִ����˻���ʧ10000Ԫ

            //��ֵ
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count+=ps.executeUpdate();

            //�������ߵ�����˵�����ϳ���û���쳣������������ֶ��ύ����
            conn.commit();
            System.out.println(count==2?"ת�˳ɹ�":"ת��ʧ��");
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
