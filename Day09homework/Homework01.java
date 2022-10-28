/*
1、计算1000以内所有不能被7整除的整数之和
*/
public class Homework01
{
	public static void main(String[] args)
	{
		int i=0;
		int result=0;
		for(i=0;i<=1000;i++)
		{
			if(i%7!=0)
			{
				result+=i;
			}
		}
		System.out.println(result);
	}
}