package com.shamengxin.java.Homework;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.*;

/*拷贝目录：
        将D:\course拷贝到C盘根下....

        需要使用到：
        FileInputStream
        FileOutputStream
        File

        可能需要使用到递归。你尝试实现一下！*/
public class Homework {
    public static void main(String[] args) {
        //源目录
        File srcFile=new File("D:\\编程");
        //目标目录
        File destFile=new File("B:\\");
        //拷贝方法
        copyDir(srcFile,destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        //判断是否为文件，如果是的话进行拷贝
        if(srcFile.isFile()){
            FileInputStream in=null;
            FileOutputStream out=null;
            try {
                in=new FileInputStream(srcFile);//源文件输入流
                //把源文件目录和目标目录的路径进行拼接，substring(3)截去源文件的盘符
                String path=(destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcFile.getAbsolutePath().substring(3);
                out=new FileOutputStream(path);
                byte[] bytes=new byte[1024*1024];//1M
                //进行拷贝
                int readCount=0;
                while ((readCount=in.read(bytes))!=-1){
                    out.write(bytes,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //获取当前路径下的文件
        File[] files=srcFile.listFiles();
        for(File file:files){
            //判断是否为目录
            if(file.isDirectory()){
                String srcDir=file.getAbsolutePath();
                String destDir=(destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcDir.substring(3);
                File newFile=new File(destDir);
                //判断目录是否存在
                if(!newFile.exists()){
                    //如不存在则创建目录
                    newFile.mkdirs();
                }
            }
            //进行递归
            copyDir(file,destFile);
        }
    }
}
