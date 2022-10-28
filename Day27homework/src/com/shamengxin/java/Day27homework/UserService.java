package com.shamengxin.java.Day27homework;

public class UserService {
    private String userName;
    private String password;

    public UserService() {
    }

    public UserService(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //注册方法
    public void register(String userName,String password) throws UserServiceException {
        if(userName.length()<6||userName.length()>14){
            throw new UserServiceException("用户名长度有误");
        }
        setUserName(userName);
        setPassword(password);
        System.out.println("注册成功"+this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null||!(obj instanceof UserService)){
            return false;
        }
        if(obj==this){
            return true;
        }
        UserService us=(UserService)obj;
        return this.userName.equals(us.userName)&&this.password.equals(us.password);
    }

    @Override
    public String toString() {
        return "用户名："+getUserName();
    }
}
