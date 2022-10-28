package com.shamengxin.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1�����SQLע������⣿
 *      ֻҪ�û��ṩ����Ϣ������SQL���ı�����̣�����ͽ���ˡ�
 *      ��ʹ�û��ṩ����Ϣ�к���SQL���Ĺؼ��֣�����û�в�����룬
 *      �������á�Ҫ���û���Ϣ������SQL���ı��룬��ô����ʹ��java.sql.PreparedStatement
 *      PreparedStatement�ӿڼ̳���java.sql.Statement
 *      PreparedStatement�����ڱ�������ݿ��������
 *      PreparedStatement��ԭ���ǣ�Ԥ�ȶ�SQL���Ŀ�ܽ��б��룬Ȼ���ٸ�sQL��䴫��ֵ����
 * 2�����Խ����
 *      �û�����fdas
 *      ���룺fdas' or '1'='1
 *      ��¼ʧ��
 * 3�����SQLע��Ĺؼ���ʲô��
 *      �û��ṩ����Ϣ�м�ʹ����sql���Ĺؼ��֣�������Щ�ؼ��ֲ�û�в�����롣�������á�
 * 4���Ա�һ��Statement��preparedStatement��
 *      -Statement����SQLע�����⣬PreparedStatement�����SQLע������⡣
 *      -Statement�Ǳ���һ��ִ��һ�Σ�PreparedStatement�Ǳ���һ�Σ���ִ��N�Σ�PreparedStatementЧ�ʽϸ�һЩ��
 *      -PreparedStatement���ڱ���׶������͵İ�ȫ��顣
 *
 *      ����������PreparedStatementʹ�ý϶ֻ࣬���ڼ��������������Ҫʹ��Statement
 * 5��ʲô����±���ʹ��Statement�أ�
 *      ҵ����Ҫ�����֧��SQLע��ʱ��
 *      Statement֧��SQLע�룬����ҵ����Ҫ������Ҫ����sql���ƴ�ӵı���ʹ��
 *      ���磺��Ʒ�б���������ܣ����ֻ��ʹ��sql����ƴ�ӹ��ܡ�
 */

public class JDBCTest07 {
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
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //1��ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2����ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3����ȡԤ��������ݿ��������
            //SQL���Ŀ��ӡ�����һ��������ʾһ��ռλ����һ������������һ����ֵ����ע�⣺ռλ������ʹ�õ�������������
            String sql="select * from t_user where loginName= ? and loginPwd= ?";
            //����ִ�е��˴����ᷢ��sql�����Ӹ�DBMS��Ȼ��DBMS����SQL����Ԥ�ȱ���
            ps=conn.prepareStatement(sql);
            //��ռλ������ֵ����һ�����±���1����һ�����±���2��JDBC�������±��1��ʼ��
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //4��ִ��sql
            //ע������ֻ��Ҫ��������������ɣ����贫ֵ��
            rs=ps.executeQuery();
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
            }if (ps!=null){
                try {
                    ps.close();
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
