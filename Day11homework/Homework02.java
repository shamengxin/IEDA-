/*
编写一个方法，输出大于某个正整数n的最小的质数。
思考：这个方法应该起什么名字，这个方法的形参是什么，方法的返回值类型是什么。
*/
public class Homework02{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int n=s.nextInt();
		printMinPrimeNumber(n);
	}
	public static boolean primeNumber(int n){
		for(int i=2;i<n;i++){
			if(n%i==0)
				return false;
		}
		return true;
	}

	public static void printMinPrimeNumber(int n){
		while(true){
			n++;
			boolean i=primeNumber(n);
			if(i){
				System.out.println(n);
				break;
			}
		}
	}
}