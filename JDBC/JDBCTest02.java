/*
	JDBC���delete,update
*/
public class JDBCTest02{
	public static void main(String[] srgs){
		Connection conn=null;
		Statement stmt=null;
		try{
		//1��ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2����ȡ����
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shamengxin","root","heyufeng");
		//3����ȡ���ݿ��������
		stmt=conn.createStatement();
		//4��ִ��sql���
		//JDBC�е�sql��䲻��Ҫ�ṩ�ֺŽ�β
		//String sql="delete from dept where deptno=40";
		String sql="update dept set dname='���۲�',loc='���' where deptno=30";
		int count=stmt.executeUpdate(sql);
		System.out.println(count==1?"���³ɹ�":"����ʧ��");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
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