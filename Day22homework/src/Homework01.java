/*（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
        （2）定义接口B，里面包含抽象方法void setColor(String c)。
        （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
        （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
        圆柱体的高height、颜色color。
        （5）创建主类来测试类Cylinder。*/
public class Homework01 {
    public static void main(String[] args) {
        Cylinder c1=new Cylinder(2,5,"红色");
        System.out.println(c1);
        System.out.println("面积为："+c1.area());
        c1.volume();
    }
}

interface A{
    double PI=3.14;
    double area();
}

interface B{
    void setColor(String c);
}

interface C extends A,B{
    void volume();
}

class Cylinder implements C{
    private double radius;
    private double height;
    private String Color;

    public Cylinder() {
    }

    public Cylinder(double radius, double height, String color) {
        this.radius = radius;
        this.height = height;
        Color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return Color;
    }

    @Override
    public void setColor(String color) {
        this.Color = color;
    }

    @Override
    public double area() {
        double area=2*PI*getRadius()*getHeight()+2*PI*getRadius()*getRadius();
        return area;
    }

    @Override
    public void volume() {
        double volume=PI*getRadius()*getRadius()*getHeight();
        System.out.println("体积为："+volume);
    }

    @Override
    public String toString() {
        return "一个半径为："+getRadius()+"、高为："+getHeight()+"、颜色为："+getColor()+"的圆柱体";
    }
}