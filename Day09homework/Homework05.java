/*
从键盘接收一个正整数，该正整数作为行数，输出以下图形
    *
   ***
  *****
 *******
*********
例如：输入5，则打印如上图5行。
*/
public class Homework05
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int m,n;
		for(m=1;m<=i;m++)
		{
			for(n=1;n<=i-m;n++)
				System.out.print(" ");
			for(n=1;n<=m*2-1;n++)
				System.out.print("*");
			System.out.println();
		}
		

	}
}