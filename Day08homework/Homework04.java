/*
整数大小比较：输入两个整数，比较大小，
    若x>y 输出 >
    若x=y 输出 =
    若x<y 输出 <
*/
public class Homework04
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.println("请输入两个整数：");
		int x=s.nextInt();
		int y=s.nextInt();
		if(x>y)
		{
			System.out.println(">");
		}
		else if(x<y)
			System.out.println("<");
		else
			System.out.println("=");
	}
}