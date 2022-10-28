/*
2、计算 1+2-3+4-5+6-7....+100的结果
*/
public class Homework02
{
	public static void main(String[] args)
	{
		int result=1;
		int j=0;
		int i=1;
		for(j=2;j<=100;j++)
		{
			result+=j*i;
			i=-i;
		}
		System.out.println(result);
	}
}