/*
3、从控制台输入一个正整数，计算该数的阶乘。例如输入5，阶乘为 5*4*3*2*1
*/
public class Homework03
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int result=1;
		for(int j=2;j<=i;j++)
		{
			result*=j;
		}
		System.out.println(result);
	}
}