/*在画图软件中，可以画出不同大小或颜色的圆形、矩形等几何图形。几何图形之间有许多共同的特征，如它们可以是用某种颜色画出来的，
  可以是填充的或者不填充的。此外还有些不同的特征，比如，圆形都有半径，可以根据半径计算圆形的面积和周长，矩形都有宽和高，可以
  根据宽高来计算矩形的面积和周长。
        1、编写Java程序。
        (1)使用继承机制，分别设计实现抽象类 图形类，子类类圆形类、正方形类、长方形类，要求：
        ①抽象类图形类中有属性包括画笔颜色(String类型)、图形是否填充(boolean类型：true表示填充，false表示不填充)，
        有方法获取图形面积、获取图形周长等；
        ②使用构造方法为其属性赋初值；
        ③在每个子类中都重写toString()方法，返回所有属性的信息；
        ④根据文字描述合理设计子类的其他属性和方法。

        (2)设计实现画板类，要求：
        ①画一个红色、无填充、长和宽分别为10.0与5.0的长方形；
        ②画一个绿色、有填充、半径为3.0的圆形；
        ③画一个黄色、无填充、边长为4.0的正方形；
        ④分别求三个对象的面积和周长，并将每个对象的所有属性信息打印到控制台。*/
public class Homework02 {
    public static void main(String[] args) {
        Patterning p1 = new Rectangle("红色", false, 10.0, 5.0);
        Patterning p2 = new Circle("绿色", true, 3.0);
        Patterning p3 = new Square("黄色", false, 4.0);
        DrawingBoard d1 = new DrawingBoard();
        d1.print(p1);
        d1.print(p2);
        d1.print(p3);
    }

}

class DrawingBoard{
    public void print(Patterning p){
        System.out.println(p);
        p.gitArea();
        p.gitPerimeter();
    }
}

class Square extends Patterning{
    private double side;

    public Square() {
    }

    public Square(String color, boolean fill, double side) {
        super(color, fill);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String toString() {
        return "一个"+getColor()+"、"+getFill()+"、边长为："+getSide()+"的正方形";
    }

    public void gitArea() {
        System.out.println("面积为："+getSide()*getSide());
    }

    public void gitPerimeter() {
        System.out.println("周长为："+4*getSide());
    }
}

class Rectangle extends Patterning{
    private double length;
    private double wide;

    public Rectangle() {
    }

    public Rectangle(String color, boolean fill, double length, double wide) {
        super(color, fill);
        this.length = length;
        this.wide = wide;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public String toString() {
        return "一个"+getColor()+"、"+getFill()+"、长和宽分别为："+getLength()+"与"+getWide()+"的长方形";
    }

    public void gitPerimeter() {
        System.out.println("周长为："+2*(getWide()+getLength()));
    }

    public void gitArea() {
        System.out.println("面积为："+getLength()*getWide());
    }
}

class Circle extends Patterning{
    private double radius;

    public Circle() {
    }

    public Circle(String color, boolean fill, double radius) {
        super(color, fill);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "一个"+getColor()+"、"+getFill()+"、半径为"+getRadius()+"的圆形";
    }

    public void gitArea() {
        System.out.println("面积为："+(3.14*radius*radius));
    }

    public void gitPerimeter() {
        System.out.println("周长为："+(2*3.14*getRadius()));
    }
}

abstract class Patterning{
    private String color;
    private boolean fill;

    public Patterning() {
    }

    public Patterning(String color, boolean fill) {
        this.color = color;
        this.fill = fill;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFill() {
        if(fill==true){
            return "有填充";
        }else{
            return "无填充";
        }
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public abstract void gitArea();
    public abstract void gitPerimeter();
}