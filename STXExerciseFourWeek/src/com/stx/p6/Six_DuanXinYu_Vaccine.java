package com.stx.p6;

import java.util.Date;

public class Six_DuanXinYu_Vaccine {
    private String name="";
    private String needTime="";
    private Date inoculateDate=new Date(1997-01-01);
    private Date appointmentDate=new Date(1997-01-01);
    private int status=2;
    private String description;

    public Six_DuanXinYu_Vaccine() {
    }

    public Six_DuanXinYu_Vaccine(String name, String needTime, Date inoculateDate, Date appointmentDate, int status) {
        this.name = name;
        this.needTime = needTime;
        this.inoculateDate = inoculateDate;
        this.appointmentDate = appointmentDate;
        this.status = status;

    }
    public String description(){
        return "vaccine description...";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeedTime() {
        return needTime;
    }

    public void setNeedTime(String needTime) {
        this.needTime = needTime;
    }

    public Date getInoculateDate() {
        return inoculateDate;
    }

    public void setInoculateDate(Date inoculateDate) {
        this.inoculateDate = inoculateDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
