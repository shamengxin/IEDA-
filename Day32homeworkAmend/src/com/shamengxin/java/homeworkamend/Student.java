package com.shamengxin.java.homeworkamend;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private static final long serialVersionUID= 5407793439762664371L;

   private int no;
   private String name;
   private String birth;
   private String sex;
   private String email;

    public Student() {
    }

    public Student(int no, String name, String birth, String sex, String email) {
        this.no = no;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.email = email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return no == student.no &&
                sex == student.sex &&
                Objects.equals(name, student.name) &&
                Objects.equals(birth, student.birth) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, birth, sex, email);
    }

    @Override
    public String toString() {
        return getNo()+"\t"+getName()+"\t"+getSex();
    }
}
