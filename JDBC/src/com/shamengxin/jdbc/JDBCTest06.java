package com.shamengxin.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
实现业务：
    1、需求：模拟实现用户登录
    2、业务描述：
        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码，
        用户输入用户名和密码之后，提交信息，java程序收集到用户信息，java
        程序连接数据库验证用户名和密码是否合法
        合法：显示登录成功
        不合法：显示登录失败
    3、数据的准备：
        在实际开发中，表的设计会使用专业的建模工具，使用:PowerDesigner进行设计。
        (参见user-login.sql脚本)
    4、当前程序存在的问题：
        用户名：fdsa
        密码：fdsa' or '1'='1
        登录成功
        这种现象被称为SQL注入。
    5、导致SQL注入的根本原因是什么？
        用户输入的信息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，
        导致sql语句的原意被扭曲，进而达到sql注入。
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo=initUI();
        //验证用户名和密码
        boolean loginSuccess=login(userLoginInfo);
        //输出结果
        System.out.println(loginSuccess?"登录成功":"登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记的意识
        boolean loginSuccess=false;
        //单独定义变量
        String loginName=userLoginInfo.get("userName");
        String loginPwd=userLoginInfo.get("passWord");

        //JDBC代码
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3、获取数据库操作对象
            stmt=conn.createStatement();
            //4、执行sql
            String sql="select * from t_user where loginName='"+loginName+"' and loginPwd='"+loginPwd+"'";
            rs=stmt.executeQuery(sql);
            //5、处理结果集
            if(rs.next()){
                loginSuccess=true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6、释放资源
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
     * 初始化用户界面
     * @return 用户输入的用户名和密码
     */
    private static Map<String, String> initUI() {
        Scanner in=new Scanner(System.in);

        System.out.print("用户名：");
        String userName=in.nextLine();

        System.out.print("密码：");
        String passWord=in.nextLine();

        Map<String,String> userLoginInfo =new HashMap<>();
        userLoginInfo.put("userName",userName);
        userLoginInfo.put("passWord",passWord);

        return userLoginInfo;
    }
}
