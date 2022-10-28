/*
根据指定月份，打印该月份所属的季节。
    3,4,5 春季 
    6,7,8 夏季 
    9,10,11 秋季 
    12, 1, 2 冬季
 
    if和switch各写一版
*/
public class Homework01
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.print("请输入所处月份：");
		int i=s.nextInt();
		if(i>=1&&i<=12)
		{
			switch(i)
			{
				case 3:case 4:case 5:
					System.out.println("现在所处月份是春季！");
					break;
				case 6:case 7:case 8:
					System.out.println("现在所处月份是夏季！");
					break;
				case 9:case 10:case 11:
					System.out.println("现在所处月份是秋季！");
					break;
				case 1:case 2:case 12:
					System.out.println("现在所处月份是冬季！");
					break;
			}
			/*这是if版
			if(i>=3&&i<=5)
			{
				System.out.println("现在所处月份是春季！");
			}
			else if(i>=6&&i<=8)
			{
				System.out.println("现在所处月份是夏季！");
			}
			else if(i>=9&&i<=11)
			{
				System.out.println("现在所处月份是秋季！");
			}
			else
			{
				System.out.println("现在所处月份是冬季！");
			}
			*/
		}
		else
		{
			System.out.println("输入月份有误，程序退出！");
		}
	}
}