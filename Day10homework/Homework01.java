/*
题目：一个5位数，判断它是不是回文数。即12321是回文数，
个位与万位相同，十位与千位相同
*/
public class Homework01{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.print("请输入一个5位数:");
		int k=s.nextInt();
		int i=k;
		int num=0;
		if(i<9999||i>99999)
			System.out.println("输入值非法！");
		else{
			while(i!=0){
				int tmp=i%10;
				num=num*10+tmp;
				i/=10;
			}
			if(k==num){
				System.out.println(k+"是一个回文数");
			}
			else{
				System.out.println(k+"不是一个回文数");
			}
		}
	}
}