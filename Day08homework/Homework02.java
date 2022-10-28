/*
从键盘接收一个数字，判断该数字的正负。
*/
public class Homework02
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		if(i>0)
		{
			System.out.println("该数为正数！");
		}
		else if(i<0)
		{
			System.out.println("该数为负数！");
		}
		else
		{
			System.out.println("既不是正数也不是负数！");
		}
	}
}