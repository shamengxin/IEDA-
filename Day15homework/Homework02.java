/*
写一个名为Account的类模拟账户。
该类的属性和方法如下所示。
该类包括的属性：账户id，余额balance，年利率annualInterestRate；
包含的方法：各属性的set和get方法。取款方法withdraw()，存款方法deposit()
 
写一个测试程序
（1）创建一个Customer，名字叫Jane Smith，他有一个账号为1000，余额为2000，
年利率为1.23%的账户
（2）对Jane Smith操作：
存入100元，再取出960元，再取出2000。
打印Jane Smith的基本信息
信息如下显示：
成功存入：100
成功取出：960
余额不足，取钱失败
Customer [Smith，Jane] has a account ：id is 1000 annualInterestRate is 1.23% 
balance is 1140.0
*/
public class Homework02{
	public static void main(String[] args){
		Account a=new Account("1000",2000,1.23);
		Customer c=new Customer("Jane Smith",a);
		c.getAct().deposit(100);
		c.getAct().withdraw(960);
		c.getAct().withdraw(2000);
	}
}
class Account{
	private String id;
	private double balance;
	private double annualInterestRate;

	public Account(){
	
	}

	public Account(String id,double balance,double annualInterestRate){
		this.id=id;
		this.balance=balance;
		this.annualInterestRate=annualInterestRate;
	}

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate=annualInterestRate;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	//取
	public void withdraw(double money){
		if(money>this.getBalance()){
			System.out.println("余额不足，取钱失败");
			return;
		}
		this.setBalance(this.getBalance()-money);
		System.out.println("成功取出："+money);
	}
	//存
	public void deposit(double money){
		//this.balance+=money;
		this.setBalance(this.getBalance()+money);
		System.out.println("成功存入："+money);
	}
}

class Customer{
	private String name;
	private Account act;
	
	public Customer(){
	
	}
	public Customer(String name,Account act){
		this.name=name;
		this.act=act;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAct(Account act){
		this.act=act;
	}
	public Account getAct(){
		return act;
	}

}