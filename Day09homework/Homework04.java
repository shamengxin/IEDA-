/*
从控制台接收一个正整数，判断该数字是否为质数
质数（质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数）
*/
public class Homework04
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int j=0;
		boolean k=true;
		for(j=2;j<i;j++)
		{
			if(i%j==0)
				k=false;
			   break;
		}
		if(k==true)
			System.out.println(i+"是质数");
		else
			System.out.println(i+"不是质数");
	}
}