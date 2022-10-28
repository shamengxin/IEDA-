/*
编写一个方法，求整数n的阶乘，例如5的阶乘是1*2*3*4*5
思考：这个方法应该起什么名字，这个方法的形参是什么，方法的返回值类型是什么。
*/
public class Homework01{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int n=s.nextInt();
		factoral(n);
	}
	public static void factoral(int n){
		int sum=1;
		for(int i=1;i<=n;i++){
			sum*=i;
		}
		System.out.println(n+"的阶乘为："+sum);
	}
}