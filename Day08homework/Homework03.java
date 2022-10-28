/*
从键盘接收一个数字，判断该数字的奇偶。
*/
public class Homework03
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		if(0==i%2)
		{
			System.out.println("该数为偶数！");
		}
		else
		{
			System.out.println("该数为奇数！");
		}
	}
}