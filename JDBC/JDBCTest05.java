/*
	处理查询结果集
*/
public class JDBCTest05{
	public static void main(String[] argds){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			//1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
			//3、获取数据库操作对象
			stmt=conn.createStatement();
			//4、执行sql
			String sql="select empno as a,ename,sal from emp";
			//int  executeUpdate(insert/delete/update)
			//ResultSet  executeQuery(select)
			rs=stmt.executeQuery(sql);
			//5、处理查询结果集
			while(rs.next()){
					/*
					//getString()方法的特点：不管数据库中的数据是什么类型是什么，都是以String的形式取出
					String empno=rs.getString(1);//JDBC中所有的下标都是从1开始
					String ename=rs.getString(2);
					String sal=rs.getString(3);
					System.out.println(empno+","+ename+","+sal);
					*/
					
					/*
					//这个是以列名称的的方式获取
					//String empno=rs.getString(empno);
					String empno=rs.getString("a");//重点：列名称不是表中的列名称，是查询结果集的列名称
					String ename=rs.getString("ename");
					String sal=rs.getString("sal");
					System.out.println(empno+","+ename+","+sal);
					*/
					
					//除了可以以String类型取出以外，还可以以特定的类型取出
					int empno=rs.getInt(1);
					String ename=rs.getString(2);
					double sal=rs.getDouble(3);
					System.out.println(empno+","+ename+","+(sal+100));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
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