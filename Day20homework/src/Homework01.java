/*（1）定义一个抽象类Weapon,该抽象类有两个抽象方法attack()，move()
        这两个方法分别表示武器的攻击方式和移动方式。

        （2）定义3个类：Tank,Flighter,WarShip都继承自Weapon,
        分别用不同的方式实现Weapon类中的抽象方法。

        编写测试程序main方法，创建多个不同武器的实例。并分别调用attack()和move()方法。
        能用多态尽量使用多态。*/
public class Homework01 {
    public static void main(String[] args) {
        Weapon w1=new Tank();
        Weapon w2=new Flighter();
        Weapon w3=new WarShip();
        w1.attack();
        w1.move();
        w2.attack();
        w2.move();
        w3.attack();
        w3.move();
    }
}
abstract class Weapon{
    public abstract void attack();
    public abstract void move();
}

class WarShip extends Weapon{
    public void attack() {
        System.out.println("军舰开炮");
    }

    public void move() {
        System.out.println("军舰移动");
    }
}

class Flighter extends Weapon{
    public void attack() {
        System.out.println("战斗机射击");
    }

    public void move() {
        System.out.println("战斗机飞行");
    }
}

class Tank extends Weapon{

    public void attack() {
        System.out.println("坦克开炮");
    }

    public void move() {
        System.out.println("坦克移动");
    }
}