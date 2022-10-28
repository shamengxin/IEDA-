/*
	注册驱动的另一种方式（这种方式常用）
*/
public class JDBCTest03{
	public static void main(String[] args){
		try{
		//1、注册驱动
		//这是驱动的第一种写法
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//驱动的第二种写法:常用的
		//为什么这中方式常用？因为参数是一个字符串，字符串可以写到xxx.properties文件中
		//以下方法不需要接收返回值，因为我们只想用它的类加载动作
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
		System.out.println(conn);
		//com.mysql.jdbc.JDBC4Connection@2aaf7cc2
		//com.mysql.jdbc.JDBC4Connection@725bef66
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}