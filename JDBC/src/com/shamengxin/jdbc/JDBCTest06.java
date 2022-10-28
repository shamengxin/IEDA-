package com.shamengxin.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
ʵ��ҵ��
    1������ģ��ʵ���û���¼
    2��ҵ��������
        �������е�ʱ���ṩһ���������ڣ��������û������û��������룬
        �û������û���������֮���ύ��Ϣ��java�����ռ����û���Ϣ��java
        �����������ݿ���֤�û����������Ƿ�Ϸ�
        �Ϸ�����ʾ��¼�ɹ�
        ���Ϸ�����ʾ��¼ʧ��
    3�����ݵ�׼����
        ��ʵ�ʿ����У������ƻ�ʹ��רҵ�Ľ�ģ���ߣ�ʹ��:PowerDesigner������ơ�
        (�μ�user-login.sql�ű�)
    4����ǰ������ڵ����⣺
        �û�����fdsa
        ���룺fdsa' or '1'='1
        ��¼�ɹ�
        �������󱻳�ΪSQLע�롣
    5������SQLע��ĸ���ԭ����ʲô��
        �û��������Ϣ�к���sql���Ĺؼ��֣�������Щ�ؼ��ֲ���sql���ı�����̣�
        ����sql����ԭ�ⱻŤ���������ﵽsqlע�롣
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        //��ʼ��һ������
        Map<String,String> userLoginInfo=initUI();
        //��֤�û���������
        boolean loginSuccess=login(userLoginInfo);
        //������
        System.out.println(loginSuccess?"��¼�ɹ�":"��¼ʧ��");
    }

    /**
     * �û���¼
     * @param userLoginInfo �û���¼��Ϣ
     * @return false��ʾʧ�ܣ�true��ʾ�ɹ�
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //���ǵ���ʶ
        boolean loginSuccess=false;
        //�����������
        String loginName=userLoginInfo.get("userName");
        String loginPwd=userLoginInfo.get("passWord");

        //JDBC����
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //1��ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2����ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3����ȡ���ݿ��������
            stmt=conn.createStatement();
            //4��ִ��sql
            String sql="select * from t_user where loginName='"+loginName+"' and loginPwd='"+loginPwd+"'";
            rs=stmt.executeQuery(sql);
            //5����������
            if(rs.next()){
                loginSuccess=true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6���ͷ���Դ
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return loginSuccess;
    }

    /**
     * ��ʼ���û�����
     * @return �û�������û���������
     */
    private static Map<String, String> initUI() {
        Scanner in=new Scanner(System.in);

        System.out.print("�û�����");
        String userName=in.nextLine();

        System.out.print("���룺");
        String passWord=in.nextLine();

        Map<String,String> userLoginInfo =new HashMap<>();
        userLoginInfo.put("userName",userName);
        userLoginInfo.put("passWord",passWord);

        return userLoginInfo;
    }
}
