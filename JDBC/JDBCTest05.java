/*
	�����ѯ�����
*/
public class JDBCTest05{
	public static void main(String[] argds){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			//1��ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2����ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
			//3����ȡ���ݿ��������
			stmt=conn.createStatement();
			//4��ִ��sql
			String sql="select empno as a,ename,sal from emp";
			//int  executeUpdate(insert/delete/update)
			//ResultSet  executeQuery(select)
			rs=stmt.executeQuery(sql);
			//5�������ѯ�����
			while(rs.next()){
					/*
					//getString()�������ص㣺�������ݿ��е�������ʲô������ʲô��������String����ʽȡ��
					String empno=rs.getString(1);//JDBC�����е��±궼�Ǵ�1��ʼ
					String ename=rs.getString(2);
					String sal=rs.getString(3);
					System.out.println(empno+","+ename+","+sal);
					*/
					
					/*
					//������������Ƶĵķ�ʽ��ȡ
					//String empno=rs.getString(empno);
					String empno=rs.getString("a");//�ص㣺�����Ʋ��Ǳ��е������ƣ��ǲ�ѯ�������������
					String ename=rs.getString("ename");
					String sal=rs.getString("sal");
					System.out.println(empno+","+ename+","+sal);
					*/
					
					//���˿�����String����ȡ�����⣬���������ض�������ȡ��
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