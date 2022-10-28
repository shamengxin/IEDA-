/*
定义丈夫类 Husband 和妻子类 Wife，
丈夫类的属性包括：身份证号，姓名，出生日期，妻子。
妻子类的属性包括：身份证号，姓名，出生日期，丈夫。
分别给这两个类提供构造方法（无参数构造方法和有参数构造方法都要提供），
编写测试程序，创建丈夫对象，然后再创建妻子对象，丈夫对象关联妻子对象，
妻子对象关联丈夫对象，要求能够输出这个“丈夫对象”的妻子的名字，
或者能够输出这个“妻子对象”的丈夫的名字。要求能够画出程序执行过程的内存图。
并且要求在程序中演示出空指针异常的效果。
*/
public class Homework05
{
	public static void main(String[] args){
		Husband h=new Husband("11111","张三","1998-3-4",null);
		Wife w=new Wife("22222","小花","1994-3-2",null);
		h.wife=w;
		w.husband=h;
		System.out.println(h.name+"的妻子是"+h.wife.name);
		System.out.println(w.name+"的丈夫是"+w.husband.name);
	}
} 
class Husband
{
	String idCard;
	String name;
	String brith;
	Wife wife;
	public Husband(){

	}
	public Husband(String s1,String s2,String s3,Wife w){
		idCard=s1;
		name=s2;
		brith=s3;
		wife=w;
	}
}
class Wife
{
	String idCard;
	String name;
	String brith;
	Husband husband;
		public Wife(){

	}
	public Wife(String s1,String s2,String s3,Husband h){
		idCard=s1;
		name=s2;
		brith=s3;
		husband=h;
	}
}
