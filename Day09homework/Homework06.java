/*
小芳的妈妈每天给她2.5元钱，她都会存起来，但是，每当这一天是存钱的第5天
或者5的倍数的话，她都会花去6元钱，请问，经过多少天，小芳才可以存到100元钱。
*/
public class Homework06
{
	public static void main(String[] args)
	{
		int day=0;
		double deposit=0;
		while(true)
		{
			day++;
			deposit=deposit+2.5;
			if(day%5==0)
				deposit=deposit-6;
			if(deposit>=100)
			{
				System.out.println("需要经过"+day+"天才可以存到100元");
				break;
			}
			
		}
	}
}