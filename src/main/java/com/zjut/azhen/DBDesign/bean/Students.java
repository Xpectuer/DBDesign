package com.zjut.azhen.DBDesign.bean;

public class Students {
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

    public String getsRegion() {
        return sRegion;
    }

    public void setsRegion(String sRegion) {
        this.sRegion = sRegion;
    }

    public double getsCredit() {
        return sCredit;
    }

    public void setsCredit(double sCredit) {
        this.sCredit = sCredit;
    }

    private String sno;
    private String sname;

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    private String ssex;
    private String sRegion;
    private double sCredit;
}
