/*
	JDBC编程六步
*/
public class JDBCTest01{
	public static void main(String[] args){
		Connection conn=null;
		Statement stmt=null;
		try{
			//1、注册驱动
			Driver driver=new com.mysql.jdbc.Driver();//多态，夫类型引用指向子类型对象。
			//Driver dirver=new com.oracle.jdbc.driver.OracleDriver();//oracle的驱动
			DriverManager.registerDriver(driver);
			//2、获取连接
			/*
				ur1:统一资源定位符（网络中某个资源的绝对路径）
					https://www.baidu.com/ 这就是URL
				URL包括那几部分？
					协议
					IP
					PORT
					资源名

				http://182.61.200.7:80/index.html
					http:// 通信协议
					182.61.200.7 服务器IP
					80 服务器上软件的端口号
					index.html 是服务器上某个资源名
				
				jdbc:mysql://127.0.0.1:3306/shamengxin
					jdbc:mysql: 协议
					127.0.0.1 IP地址
					3306 mysql数据库端口号
					shamengxin 具体的数据库实例名

				说明：localhost和127.0.0.1都是本机的ip地址，
				      还可以获取到别人的电脑ip后改成其他人的电脑ip登录他人的数据库

				什么是通信协议，有什么用？
					通信协议是通信之前就提前定好的数据传输格式。
					数据库包具体怎么传数据，格式是提前定好的。
				
				Oracle的URL：
					jdbc:oracle:thin:@127.0.0.1:1521:orcl

			*/
			String url="jdbc:mysql://127.0.0.1:3306/shamengxin";
			String user="root";
			String password="heyufeng";
			conn=DriverManager.getConnection(url,user,password);
			//数据库连接对象=com.mysql.jdbc.JDBC4Connection@1ae369b7
			System.out.println("数据库连接对象="+conn);
			//3、获取数据库操作对象（Statement专门执行sql语句的）
			stmt=conn.createStatement();
			//4、执行sql
			String sql="insert into dept(deptno,dname,loc) values (50,'人事部','北京')";
			//专门执行DML语句的（insert，delete，update）
			//返回值是“影响数据库中的记录条数”
			int count=stmt.executeUpdate(sql);//执行DML语句
			System.out.println(count==1?"保存成功":"保存失败");
			//5、处理查询结果集
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6、释放资源
			//为了保证资源一定释放，再finally语句块中关闭资源
			//并且要遵循从小到大一次关闭
			//分别对其try...catch...
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(SQLException e){
			e.printStackTrace();
			}
			try{
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
			e.printStackTrace();
			}
		}
	}
}