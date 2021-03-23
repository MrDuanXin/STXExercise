package com.stx.p6;

public class Six_DuanXinYu_User {
    private String uname;
    private String upwd;
    private String uphone;
    private Six_DuanXinYu_Vaccine vaccine;

    public Six_DuanXinYu_User() {
    }

    public Six_DuanXinYu_User(String uname, String upwd, String uphone, Six_DuanXinYu_Vaccine vaccine) {
        this.uname = uname;
        this.upwd = upwd;
        this.uphone = uphone;
        this.vaccine = vaccine;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Six_DuanXinYu_Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Six_DuanXinYu_Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
