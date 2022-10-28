package com.shamengxin.java.Homework;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private float grade;

    public Student() {
    }

    public Student(String name, int age, float grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if(this.grade==o.grade){
            return this.age-o.age;
        }
        return (int)(this.grade-this.grade);
    }

    @Override
    public String toString() {
        return "姓名："+this.getName()+" "+"年龄："+this.getAge()+" "+"分数："+this.getGrade();
    }
}
