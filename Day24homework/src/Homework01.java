/*写一个类Army,代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的所有武器），
        该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量,
        并用这一大小来初始化数组w。

        该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。
        在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击；
        以及moveAll()让w数组中的所有可移动的武器移动。

        写一个主方法去测试以上程序。

        提示：
        Weapon是一个父类。应该有很多子武器。
        这些子武器应该有一些是可移动的，有一些
        是可攻击的。*/
public class Homework01 {
    public static void main(String[] args) {
        Army army=new Army(3);
        weapon w1=new Tank();
        weapon w2=new Gun();
        weapon w3=new Car();
        army.addweapon(w1);
        army.addweapon(w2);
        army.addweapon(w3);
        army.attackall();
        army.moveall();
    }
}

class Army{
    private weapon[] w;

    public Army(int i) {
        w=new weapon[i];
    }

    public void addweapon(weapon wa){
        for(int i=0;i<w.length;i++){
            if(w[i]==null){
                w[i]=wa;
                return ;
            }
        }
        System.out.println("武器库已满，无法添加。");
    }

    public void attackall(){
        for (int i = 0; i <w.length ; i++) {
            if(w[i]instanceof Attackable){
                Attackable attackable=(Attackable)w[i];
                attackable.attack();
            }
        }
    }

    public void moveall(){
        for (int i = 0; i <w.length ; i++) {
            if(w[i]instanceof Moveable){
                Moveable moveable=(Moveable) w[i];
                moveable.move();
            }
        }
    }
}

class Car extends weapon implements Moveable{
    @Override
    public void move() {
        System.out.println("战车开动！");;
    }
}

class Gun extends weapon implements Attackable{
    @Override
    public void attack() {
        System.out.println("用枪射击！");;
    }
}

class Tank extends weapon implements Attackable,Moveable{
    @Override
    public void attack() {
        System.out.println("坦克攻击！");;
    }

    @Override
    public void move() {
        System.out.println("坦克移动");;
    }
}

interface Attackable{
    void attack();
}

interface Moveable{
    void move();
}

class weapon{

}