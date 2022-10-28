/*编写程序模拟“主人”喂养“宠物”的场景：
        提示1：
        主人类：Master
        宠物类：Pet
        宠物类子类：Dog、Cat、YingWu
        提示2：
        主人应该有喂养的方法：feed()
        宠物应该有吃的方法：eat()
        只要主人喂宠物，宠物就吃。

        要求：主人类中只提供一个喂养方法feed()，要求达到可以喂养各种类型的宠物。

        编写测试程序：
        创建主人对象
        创建各种宠物对象
        调用主人的喂养方法feed()，喂养不同的宠物，观察执行结果。*/
public class Homework02 {
    public static void main(String[] args) {
        Master m=new Master();
        Pet p1=new Dog();
        Pet p2=new Cat();
        Pet p3=new YingWu();
        m.feed(p1);
        m.feed(p2);
        m.feed(p3);
    }
}

class Master {
    public void feed(Pet p){
        p.eat();
    }
}

class Pet {
    public void eat(){};
}

class Dog extends Pet{
    public void eat() {
        System.out.println("狗吃的很香");
    }
}

class Cat extends Pet{
    public void eat() {
        System.out.println("猫吃的很香");
    }
}

class YingWu extends Pet{
    public void eat() {
        System.out.println("鹦鹉吃的很香");
    }
}