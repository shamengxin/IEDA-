/*定义一个学生类
        属性包括：学生编号、学生姓名、学生年龄
        属性私有化，对外提供公开的set和get方法
        提供无参构造和有参数构造方法
        提供一个display()方法，通过该方法打印学生信息。
        编写测试程序创建对象，调用display()方法。*/
public class Homework02 {
    public static void main(String[] args) {
        Students s1=new Students("1111","小花",18);
        s1.display();
    }
}
class Students{
    private String number;
    private String name;
    private int age;

    public Students() {
    }

    public Students(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display(){
        System.out.println("姓名："+getName()+"\n编号："+getNumber()+"\n年龄："+getAge());
    }
}
