//将连接数据库的所有信息配置到配置文件中
/*
	实际开发中不建议把连接数据库的信息写死到java程序中
*/
public class JDBCTest04{
	public static void main(String[] args){
		//使用资源绑定器
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		String driver=bundle.getString("driver");
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");

		Connection conn=null;
		Statement stmt=null;
		try{
			//1、注册驱动
			Class.forName(driver);
			//2、获取连接
			conn=DriverManager.getConnection(url,user,password);
			//3、获取操作对象
			stmt=conn.createStatement();
			//4、执行sql语句
			String sql="insert into dept(deptno,dname,loc) values (40,'后勤部','湖北')";
			int count=stmt.executeUpdate(sql);
			System.out.println(count==1?"插入成功":"插入失败");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6、释放资源
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
}