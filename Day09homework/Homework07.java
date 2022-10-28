/*
一个数如果恰好等于它的因子之和，这个数就是完数，例如 6 = 1 + 2 + 3，编程
找出1000内所有的完数
*/
public class Homework07{
	public static void main(String[] args){
		System.out.print("1000以内的完数：");
		for(int i=2;i<=1000;i++){
			int tmp=0;
			for(int n=1;n<i;n++){
				if(i%n==0)
					tmp+=n;
			}
			if(i==tmp)
				System.out.print(i+" ");
		}
	}
}