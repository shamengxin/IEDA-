package com.shamengxin.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Statement֧��SQLע�룬����ҵ����Ҫ������Ҫ����sql���ƴ�ӵı���ʹ��
 * ��ʾ
 */

public class JDBCTest08 {
    public static void main(String[] args) {
        //�û��ڿ���̨����desc���ǽ���asc��������
        Scanner in=new Scanner(System.in);
        System.out.println("������desc��asc��desc��ʾ����asc��ʾ����");
        System.out.print("�����룺");
        String keyWord=in.nextLine();
        //ִ��sql
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        //ע������
        try {
            //1��ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2����ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3�����ݿ��������
            stmt=conn.createStatement();
            //4��ִ��sql
            String sql="select ename from emp order by ename "+keyWord;
            rs=stmt.executeQuery(sql);
            //5�������ѯ�����
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
