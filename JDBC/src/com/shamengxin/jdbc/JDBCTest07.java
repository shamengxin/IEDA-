package com.shamengxin.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1、解决SQL注入的问题？
 *      只要用户提供的信息不参与SQL语句的编译过程，问题就解决了。
 *      即使用户提供的信息中含有SQL语句的关键字，但是没有参与编译，
 *      不起作用。要想用户信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
 *      PreparedStatement接口继承了java.sql.Statement
 *      PreparedStatement是属于编译的数据库操作对象
 *      PreparedStatement的原理是：预先对SQL语句的框架进行编译，然后再给sQL语句传“值”。
 * 2、测试结果：
 *      用户名：fdas
 *      密码：fdas' or '1'='1
 *      登录失败
 * 3、解决SQL注入的关键是什么？
 *      用户提供的信息中即使含有sql语句的关键字，但是这些关键字并没有参与编译。不起作用。
 * 4、对比一下Statement和preparedStatement？
 *      -Statement存在SQL注入问题，PreparedStatement解决了SQL注入的问题。
 *      -Statement是编译一次执行一次，PreparedStatement是编译一次，可执行N次，PreparedStatement效率较高一些。
 *      -PreparedStatement会在编译阶段做类型的安全检查。
 *
 *      综上所述：PreparedStatement使用较多，只有在极少数的情况下需要使用Statement
 * 5、什么情况下必须使用Statement呢？
 *      业务方面要求必须支持SQL注入时候。
 *      Statement支持SQL注入，凡是业务方面要求是需要进行sql语句拼接的必须使用
 *      例如：商品列表的升降序功能，这个只能使用sql语句的拼接功能。
 */

public class JDBCTest07 {
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
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
            //3、获取预编译的数据库操作对象
            //SQL语句的框子。其中一个？，表示一个占位符，一个？将来接收一个“值”，注意：占位符不能使用单引号括起来。
            String sql="select * from t_user where loginName= ? and loginPwd= ?";
            //程序执行到此处，会发送sql语句框子给DBMS，然后DBMS进行SQL语句的预先编译
            ps=conn.prepareStatement(sql);
            //给占位符？传值（第一个？下标是1，第一个？下标是2，JDBC中所有下标从1开始）
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //4、执行sql
            //注：这里只需要调用这个方法即可，无需传值。
            rs=ps.executeQuery();
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
