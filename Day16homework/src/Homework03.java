import java.awt.*;

/*在程序中经常要对时间进行操作但是并没有时间类型的数据。
        那么我们可以自己实现一个时间类来满足程序中的需要。
        定义名为MyTime的类其中应有三个整型成员时hour分minute秒second
        为了保证数据的安全性这三个成员变量应声明为私有。
        为MyTime类定义构造方法以方便创建对象时初始化成员变量。
        再定义display方法用于将时间信息打印出来。
        为MyTime类添加以下方法
        addSecond(int sec)
        addMinute(int min)
        addHour(int hou)
        subSecond(int sec)
        subMinute(int min)
        subHour(int hou)
        分别对时、分、秒进行加减运算。*/
public class Homework03 {
    public static void main(String[] args) {
        MyTime t1=new MyTime();
        t1.display();
        MyTime t2=new MyTime(16,05,40);
        t2.display();
    }
}
class MyTime{
    private int hour;
    private int minute;
    private int second;

    //这里的时分秒的加减需要条件，分秒到60加1，或者是减时候需要向高位借1，当时变为24的时候就要归0，这不在叙述
    //需要的条件自行编写
    public void subHour(int hou){
        setHour(this.getHour()-hou);
    }

    public void addHour(int hou){
        setHour(this.getHour()+hou);
    }

    public void subMinute(int min){
        setMinute(this.getMinute()-min);
    }

    public void addMinute(int min){
        setMinute(this.getMinute()+min);
    }

    public void subSecond(int sec){
        setSecond(this.getSecond()-sec);
    }

    public void addSecond(int sec){
        setSecond(this.getSecond()+sec);
    }

    public void display(){
        System.out.println(this.getHour()+"时"+this.getMinute()+"分"+this.getSecond()+"秒");
    }

    public MyTime() {
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
