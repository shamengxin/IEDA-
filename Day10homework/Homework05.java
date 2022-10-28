/*
一个四位数，恰好等于去掉它的首位数字之后所剩的三位数的3倍，这个
四位数是多少？
*/
public class Homework05{
	public static void main(String[] args){
		for(int i=1000;i<10000;i++){
			int n=i%1000;
			if(n*3==i){
				System.out.println("这个四位数是："+i);
			}
		}
	}
}