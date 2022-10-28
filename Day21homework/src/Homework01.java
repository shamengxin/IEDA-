/*
开放型题目：
        设计一个笔记本电脑类，属性随意，并且进行属性私有化，对外提供公开的set和get方法。

        设计一个可插拔的接口：InsertDrawable，该接口有什么方法自行定义。

        设计一个鼠标类，实现InsertDrawable接口，并实现方法。
        设计一个键盘类，实现InsertDrawable接口，并实现方法。
        设计一个显示器类，实现InsertDrawable接口，并实现方法。
        设计一个打印机类，实现InsertDrawable接口，并实现方法。

        在“笔记本电脑类”中有一个InsertDrawable接口属性，可以让笔记本
        电脑可插拔鼠标、键盘、显示器、打印机等。

        编写测试程序，创建多个对象，演示接口的作用。
*/
public class Homework01 {
    public static void main(String[] args) {
        //创建对象
        InsertDrawable mouse=new Mouse();
        InsertDrawable keyboard=new Keyboard();
        InsertDrawable display=new Display();
        InsertDrawable printer=new Printer();
        //创建电脑对象
        Computer c1=new Computer();
        //进行插入
        c1.getSlot()[0]=mouse;
        c1.getSlot()[1]=keyboard;
        c1.getSlot()[2]=display;
        c1.getSlot()[3]=printer;
        //工作
        c1.getSlot()[0].work();
        c1.getSlot()[1].work();
        c1.getSlot()[2].work();
        c1.getSlot()[3].work();

    }
}

interface InsertDrawable{
    void work();
}

class Mouse implements InsertDrawable{
    @Override
    public void work() {
        System.out.println("鼠标已接入，正在工作！");
    }
}

class Keyboard implements InsertDrawable{
    @Override
    public void work() {
        System.out.println("键盘已接入，正在工作！");
    }
}

class Display implements InsertDrawable{
    @Override
    public void work() {
        System.out.println("显示器已接入，正在工作！");
    }
}

class Printer implements InsertDrawable{
    @Override
    public void work() {
        System.out.println("打印机已接入，正在工作！");
    }
}

class Computer{
    private InsertDrawable slot[];

    //初始化时有5个接口
    public Computer() {
        this(new InsertDrawable[5]);
    }

    public Computer(InsertDrawable[] slot) {
        this.slot = slot;
    }

    public InsertDrawable[] getSlot() {
        return slot;
    }

    public void setSlot(InsertDrawable[] slot) {
        this.slot = slot;
    }
}