/*
打车起步价8元（3KM以内）
超过3KM，超出的每公里1.2元
超过5KM，超出的每公里1.5元
请在键盘上接收公里数，得出总价。
*/
public class Homework06
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.printf("请输入所行驶的公里数：");
		int i=s.nextInt();
		if(i<=3)
			System.out.printf("所需费用为8元。");
		else if(i>3&&i<=5)
		{
			double j=8+(i-3)*1.2;
			System.out.printf("所需费用为"+j+"元。");
		}
		else
		{
			double k=8+2*1.2+(i-5)*1.5;
			System.out.printf("所需费用为"+k+"元。");
		}

	}
}