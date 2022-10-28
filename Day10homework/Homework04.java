/*
题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半再落下，
求它在第10次落地时，共经过多少米
*/
public class Homework04{
	public static void main(String[] args){
		double sum=100;
		double high=100.0;
		for(int i=0;i<10;i++){
			high*=0.5;
			sum=sum+high*2;
		}
		System.out.println("一共经过"+sum+"米");
	}
}