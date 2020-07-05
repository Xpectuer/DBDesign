package com.zjut.azhen.DBDesign.bean;

public class Course {

    private String cno;
    private String cname;
    private double cCredit;

    //开设学期

    private String cTerm;

    //开设时间

    private String cTime;

    //考核方式

    private String cTest;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getcCredit() {
        return cCredit;
    }

    public void setcCredit(double cCredit) {
        this.cCredit = cCredit;
    }

    public String getcTerm() {
        return cTerm;
    }

    public void setcTerm(String cTerm) {
        this.cTerm = cTerm;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getcTest() {
        return cTest;
    }

    public void setcTest(String cTest) {
        this.cTest = cTest;
    }
}
