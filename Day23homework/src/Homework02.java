import java.util.Scanner;

/*为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
        1、该系统的用户是：酒店前台。
        2、酒店使用一个二维数组来模拟。“Room[][] rooms;”
        3、酒店中的每一个房间应该是一个java对象：Room
        4、每一个房间Room应该有：房间编号、房间类型、房间是否空闲.
        5、系统应该对外提供的功能：
        可以预定房间：用户输入房间编号，订房。
        可以退房：用户输入房间编号，退房。
        可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。*/
//目前这个系统很不完善，如当断电之后数据就初始化了，并没有保存、当房间已经订房之后还可以再次订房，退房操作同样如此
//等等这一系列的问题还有待完善。
public class Homework02 {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        System.out.println("欢迎来到酒店管理系统，请按照提示输入");
        System.out.println("1：查看房间列表\n2：订房\n3：退房\n0：退出");
        Scanner s=new Scanner(System.in);
       while(true){
            System.out.print("请输入编号：");
            int i=s.nextInt();
            if (i == 1) {
                hotel.print();
            }else if(i==2){
                System.out.print("请输入房间编号：");
                int roomNo=s.nextInt();
                hotel.order(roomNo);
            }else if(i==3){
                System.out.print("请输入房间编号：");
                int roomNo=s.nextInt();
                hotel.exit(roomNo);
            }else if(i==0){
                System.out.println("退出系统，欢迎再次使用！");
                return ;
            }else{
                System.out.println("输入有误，请重新输入！");
            }

        }

    }
}

class Hotel{
    private Room[][] rooms;

    public Hotel() {
        rooms = new Room[3][10];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (i == 0) {
                    rooms[i][j] = new Room((i+1)*100+j+1,"单人间",true);
                }else if(i==2){
                    rooms[i][j]=new Room((i+1)*100+j+1,"标准间",true);
                }else{
                    rooms[i][j]=new Room((i+1)*100+j+1,"总统套房",true);
                }
            }
        }
    }

    public void print(){
        for(int i=0;i<rooms.length;i++){
            for (int j = 0; j <rooms[i].length ; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println();
        }
    }

    public void order(int roomNO){
        Room room=rooms[roomNO/100-1][roomNO%100-1];
        room.setStatus(false);
        System.out.println(roomNO+"已订房！");
    }

    public void exit(int roomNO){
        Room room=rooms[roomNO/100-1][roomNO%100-1];
        room.setStatus(false);
        System.out.println(roomNO+"已退房！");
    }
}

class Room{
    private int no;
    private String type;
    private boolean status;

    public Room() {
    }

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "["+no+","+type+","+(status?"空闲":"占用")+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null||!(obj instanceof Room))
            return false;
        if (this==obj)
            return true;
        Room room=(Room)obj;
        /*if(this.getNo()==room.getNo())
            return true;*/
        return this.getNo()==room.getNo();
    }
}