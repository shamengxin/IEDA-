/*（1）定义一个接口CanFly，描述会飞的方法public void fly();
        （2）分别定义类飞机和鸟，实现CanFly接口。
        （3）定义一个测试类，测试飞机和鸟，在main方法中创建飞机对象和鸟对象，

        再定义一个makeFly()方法，其中让会飞的事物飞。并在main方法中调用该方法，让飞机和鸟起飞。*/
public class Homework03 {
    public static void main(String[] args) {
        CanFly c1=new Plane();
        CanFly c2=new Brid();
        Homework03 h=new Homework03();
        h.makeFly(c1);
        h.makeFly(c2);
    }
    public void makeFly(CanFly c){
        c.fly();
    }
}

class Brid implements CanFly{
    @Override
    public void fly() {
        System.out.println("鸟在飞翔！");
    }
}

class Plane implements CanFly{
    @Override
    public void fly() {
        System.out.println("飞机起飞！");
    }
}

interface CanFly{
    void fly();
}