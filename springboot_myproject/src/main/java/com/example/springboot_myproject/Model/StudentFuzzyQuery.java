package com.example.springboot_myproject.Model;
import com.example.springboot_myproject.Base.BaseQuery;
public class StudentFuzzyQuery extends BaseQuery {
    private String sno;
    private String sname;
    private String sjob;
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
}
