/*
	ע����������һ�ַ�ʽ�����ַ�ʽ���ã�
*/
public class JDBCTest03{
	public static void main(String[] args){
		try{
		//1��ע������
		//���������ĵ�һ��д��
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//�����ĵڶ���д��:���õ�
		//Ϊʲô���з�ʽ���ã���Ϊ������һ���ַ������ַ�������д��xxx.properties�ļ���
		//���·�������Ҫ���շ���ֵ����Ϊ����ֻ������������ض���
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ����
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