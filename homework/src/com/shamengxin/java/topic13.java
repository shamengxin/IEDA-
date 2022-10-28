package com.shamengxin.java;

public class topic13 {
    public static void main(String[] args) {
        {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            for (a = 1; a <= 5; a++)
            {
                for (b = 1; b <= 5; b++)
                {
                    for (c = 1; c <= 5; c++)
                    {
                        for (d = 1; d <= 5; d++)
                        {
                            for (e = 1; e <= 5; e++)
                            {
                                if (((b == 3)|(a == 5)) &&
                                        ((d == 2)||(e == 4)) &&
                                        ((b==1)||(e == 4)) &&
                                        ((c == 1)||(b == 2)) &&
                                        ((d == 2)||(a == 3)))
                                {//上面有很多的值符合，但并不是1，2，3，4，5的名次排列的，所以要增加判断条件
                                    //1+2+3+4+5=15；1*2*3*4*5=120；
                                    if ((a*b*c*d*e==120)&&(a+b+c+d+e==15)) {
                                        System.out.printf("a=%d,b=%d,c=%d,d=%d,e=%d \n", a, b, c, d, e);
                                        System.out.println("大数据02-何雨峰-2062040222");
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
