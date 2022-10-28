/*定义一个人类
        属性包括：姓名、年龄、性别
        属性私有化，对外提供公开的set和get方法
        提供无参数构造和有参数构造
        提供一个生病方法：ill()，在该方法中打印信息，例如：张三，男，29岁生病了
定义一个病毒类
        属性包括：病毒名称name、病毒体积size、病毒类型type
        属性私有化，对外提供公开的set和get方法
        提供无参数构造和有参数构造
        提供一个攻击attack()方法，该方法的参数是“人”，例如：attack(Person p)
        在attack()方法中调用人对象的生病方法。

        编写测试程序，创建病毒对象，创建人对象，模拟病毒攻击人。*/
public class Homework03 {
    public static void main(String[] args) {
        Peopel p1=new Peopel("张三",29,'男');
        Virus v1=new Virus("小流",0.1,"流感");
        v1.attack(p1);
    }
}

class Peopel{
    private String name;
    private int age;
    private char sex;

    public Peopel() {
    }

    public Peopel(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void ill(){
        System.out.println(getName()+","+getSex()+","+getAge()+"生病了");
    }
}

class Virus{
    private String name;
    private double size;
    private String type;

    public Virus(String name, double size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public Virus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void attack(Peopel p){
        p.ill();
    }
}