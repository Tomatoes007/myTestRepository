package com.example.springboot_myproject.Model;
public class DepartAndStu {
    private String did;
    private String dname;
    private String address;
    private String count1;
    private String count2;
    private String sno;
    private String sjob;
    public String getCount2() {
        return count2;
    }
    public void setCount2(String count2) {
        this.count2 = count2;
    }
    public String getDid() {
        return did;
    }
    public void setDid(String did) {
        this.did = did;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCount1() {
        return count1;
    }
    public void setCount1(String count1) {
        this.count1 = count1;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSjob() {
        return sjob;
    }
    public void setSjob(String sjob) {
        this.sjob = sjob;
    }
    @Override
    public String toString() {
        return "DepartAndStu{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                ", address='" + address + '\'' +
                ", count1='" + count1 + '\'' +
                ", sno='" + sno + '\'' +
                ", sjob='" + sjob + '\'' +
                '}';
    }
}
