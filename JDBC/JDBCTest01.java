/*
	JDBC�������
*/
public class JDBCTest01{
	public static void main(String[] args){
		Connection conn=null;
		Statement stmt=null;
		try{
			//1��ע������
			Driver driver=new com.mysql.jdbc.Driver();//��̬������������ָ�������Ͷ���
			//Driver dirver=new com.oracle.jdbc.driver.OracleDriver();//oracle������
			DriverManager.registerDriver(driver);
			//2����ȡ����
			/*
				ur1:ͳһ��Դ��λ����������ĳ����Դ�ľ���·����
					https://www.baidu.com/ �����URL
				URL�����Ǽ����֣�
					Э��
					IP
					PORT
					��Դ��

				http://182.61.200.7:80/index.html
					http:// ͨ��Э��
					182.61.200.7 ������IP
					80 ������������Ķ˿ں�
					index.html �Ƿ�������ĳ����Դ��
				
				jdbc:mysql://127.0.0.1:3306/shamengxin
					jdbc:mysql: Э��
					127.0.0.1 IP��ַ
					3306 mysql���ݿ�˿ں�
					shamengxin ��������ݿ�ʵ����

				˵����localhost��127.0.0.1���Ǳ�����ip��ַ��
				      �����Ի�ȡ�����˵ĵ���ip��ĳ������˵ĵ���ip��¼���˵����ݿ�

				ʲô��ͨ��Э�飬��ʲô�ã�
					ͨ��Э����ͨ��֮ǰ����ǰ���õ����ݴ����ʽ��
					���ݿ��������ô�����ݣ���ʽ����ǰ���õġ�
				
				Oracle��URL��
					jdbc:oracle:thin:@127.0.0.1:1521:orcl

			*/
			String url="jdbc:mysql://127.0.0.1:3306/shamengxin";
			String user="root";
			String password="heyufeng";
			conn=DriverManager.getConnection(url,user,password);
			//���ݿ����Ӷ���=com.mysql.jdbc.JDBC4Connection@1ae369b7
			System.out.println("���ݿ����Ӷ���="+conn);
			//3����ȡ���ݿ��������Statementר��ִ��sql���ģ�
			stmt=conn.createStatement();
			//4��ִ��sql
			String sql="insert into dept(deptno,dname,loc) values (50,'���²�','����')";
			//ר��ִ��DML���ģ�insert��delete��update��
			//����ֵ�ǡ�Ӱ�����ݿ��еļ�¼������
			int count=stmt.executeUpdate(sql);//ִ��DML���
			System.out.println(count==1?"����ɹ�":"����ʧ��");
			//5�������ѯ�����
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
			//Ϊ�˱�֤��Դһ���ͷţ���finally�����йر���Դ
			//����Ҫ��ѭ��С����һ�ιر�
			//�ֱ����try...catch...
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