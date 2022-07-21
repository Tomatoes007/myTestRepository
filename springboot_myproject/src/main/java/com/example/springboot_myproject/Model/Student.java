package com.example.springboot_myproject.Model;
import java.io.Serializable;
public class Student implements Serializable {
    private int sid;
    private String sno;
    private String sname;
    private String sjob;
    private String stel;
    private String sdid;
    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sjob='" + sjob + '\'' +
                ", stel='" + stel + '\'' +
                ", sdid='" + sdid + '\'' +
                '}';
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSjob() {
        return sjob;
    }
    public void setSjob(String sjob) {
        this.sjob = sjob;
    }
    public String getStel() {
        return stel;
    }
    public void setStel(String stel) {
        this.stel = stel;
    }
    public String getSdid() {
        return sdid;
    }
    public void setSdid(String sdid) {
        this.sdid = sdid;
    }
}
