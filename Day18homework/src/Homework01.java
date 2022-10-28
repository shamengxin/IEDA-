/*某公司的雇员分为以下若干类：
        Employee：这是所有员工总的父类，
        属性：
        员工的姓名,员工的生日月份。
        方法：getSalary(intmonth)
        根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100 元。

        SalariedEmployee：
        Employee 的子类，拿固定工资的员工。
        属性：月薪

        HourlyEmployee：
        Employee 的子类， 按小时拿工资的员工，每月工作超出160 小时的部分按照1.5 倍工资发放。
        属性：每小时的工资、每月工作的小时数

        SalesEmployee：
        Employee 的子类，销售人员，工资由月销售额和提成率决定。
        属性：月销售额、提成率

        BasePlusSalesEmployee：
        SalesEmployee 的子类，有固定底薪的销售人员，工资 由底薪加上销售提成部分。
        属性：底薪。

        根据要求创建 SalariedEmployee 、 HourlyEmployees 、SaleEmployee 和 BasePlusSalesEmployee四个类的对象各一个，
        并计算某个月这四个对象的工资。

        注意：要求把每个类都做成完全封装，不允许非私有化属性。*/
public class Homework01 {
    public static void main(String[] args) {
        Employee salariedEmployee=new SalariedEmployee("小月",10,5000);
        Employee hourlyEmployees=new HourlyEmployee("小花",10,10,180);
        Employee saleEmployee=new SalesEmployee("小明",6,2000,2);
        Employee basePlusSalesEmployee=new BasePlusSalesEmployee("小艾",5,1000,2,3000);

        double salary1=salariedEmployee.getSalary(10);//是生日的工资
        System.out.println(salariedEmployee.getName()+"的月薪是："+salary1);
        /*double salary1=salariedEmployee.getSalary(9);//不是生日的工资
        System.out.println(salariedEmployee.getName()+"的月薪是："+salary1);*/

        double salary2=hourlyEmployees.getSalary(10);//是生日的工资
        System.out.println(hourlyEmployees.getName()+"的月薪是："+salary2);
        /*double salary2=hourlyEmployees.getSalary(9);//不是生日的工资
        System.out.println(hourlyEmployees.getName()+"的月薪是："+salary2);*/

        double salary3=saleEmployee.getSalary(6);//是生日的工资
        System.out.println(saleEmployee.getName()+"的月薪是："+salary3);
        /*double salary3=saleEmployee.getSalary(5);//不是生日的工资
        System.out.println(saleEmployee.getName()+"的月薪是："+salary3)*/;

        double salary4=basePlusSalesEmployee.getSalary(5);//是生日的工资
        System.out.println(hourlyEmployees.getName()+"的月薪是："+salary4);
       /* double salary4=basePlusSalesEmployee.getSalary(4);//不是生日的工资
        System.out.println(hourlyEmployees.getName()+"的月薪是："+salary4);*/
    }
}

class Employee {
    private String name;
    private int month;

    public Employee() {
    }

    public Employee(String name, int month) {
        this.name = name;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getSalary(int month){
        return 0;
    }

}

class SalariedEmployee extends Employee{
    private double monthlyPay;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, int month, double monthlyPay) {
        super(name, month);
        this.monthlyPay = monthlyPay;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public double getSalary(int month) {
        if(this.getMonth()==month){
            return getMonthlyPay()+100.0;
        }else{
            return getMonthlyPay();
        }
    }
}

class HourlyEmployee extends Employee{
    private double hourlyPay;
    private int hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int month, double hourlyPay, int hour) {
        super(name, month);
        this.hourlyPay = hourlyPay;
        this.hour = hour;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getSalary(int month) {
        if(getMonth()==month) {
            if (getHour() > 160) {
                return 160 * getHourlyPay() + (getHour() - 160) * 1.5 * getHourlyPay()+100;
            } else {
                return getHourlyPay() * getHour()+100;
            }
        }else{
            if (getHour() > 160) {
                return 160 * getHourlyPay() + (getHour() - 160) * 1.5 * getHourlyPay();
            } else {
                return getHourlyPay() * getHour();
            }
        }
    }
}

class SalesEmployee extends Employee{
    private double monthlySalesVolume;
    private double royaltyRate;

    public SalesEmployee() {
    }

    public SalesEmployee(String name, int month, double monthlySalesVolume, double royaltyRate) {
        super(name, month);
        this.monthlySalesVolume = monthlySalesVolume;
        this.royaltyRate = royaltyRate;
    }

    public double getMonthlySalesVolume() {
        return monthlySalesVolume;
    }

    public void setMonthlySalesVolume(double monthlySalesVolume) {
        this.monthlySalesVolume = monthlySalesVolume;
    }

    public double getRoyaltyRate() {
        return royaltyRate;
    }

    public void setRoyaltyRate(double royaltyRate) {
        this.royaltyRate = royaltyRate;
    }


    public double getSalary(int month) {
        if(getMonth()==month){
            return getMonthlySalesVolume()*getRoyaltyRate()+100;
        }else{
            return getMonthlySalesVolume()*getRoyaltyRate();
        }
    }
}

class BasePlusSalesEmployee extends SalesEmployee{
    private double basicSalary;

    public BasePlusSalesEmployee() {
    }

    public BasePlusSalesEmployee(String name, int month, double monthlySalesVolume, double royaltyRate, double basicSalary) {
        super(name, month, monthlySalesVolume, royaltyRate);
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSalary(int month) {
        if(getMonth()==month){
            return getBasicSalary()+getMonthlySalesVolume()*getRoyaltyRate()+100;
        }else{
            return getBasicSalary()+getMonthlySalesVolume()*getRoyaltyRate();
        }
    }
}