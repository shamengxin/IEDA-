//���������ݿ��������Ϣ���õ������ļ���
/*
	ʵ�ʿ����в�������������ݿ����Ϣд����java������
*/
public class JDBCTest04{
	public static void main(String[] args){
		//ʹ����Դ����
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		String driver=bundle.getString("driver");
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");

		Connection conn=null;
		Statement stmt=null;
		try{
			//1��ע������
			Class.forName(driver);
			//2����ȡ����
			conn=DriverManager.getConnection(url,user,password);
			//3����ȡ��������
			stmt=conn.createStatement();
			//4��ִ��sql���
			String sql="insert into dept(deptno,dname,loc) values (40,'���ڲ�','����')";
			int count=stmt.executeUpdate(sql);
			System.out.println(count==1?"����ɹ�":"����ʧ��");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
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