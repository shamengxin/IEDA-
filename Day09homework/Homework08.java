/*
给一个不多于5位的正整数，
要求：
一、求它是几位数
二、逆序打印出各位数字
*/
public class Homework08{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int num=s.nextInt();
		int i=0;
		if(num>99999)
			System.out.print("输入值过大！");
		else{
			while(num>0){
				System.out.print(num%10+" ");
				i++;
				num/=10;
			}
			System.out.println();
			System.out.print("它是"+i+"位数");
		}
	}
}