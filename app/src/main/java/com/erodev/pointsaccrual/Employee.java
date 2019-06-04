package com.erodev.pointsaccrual;


public class Employee {

    int empid;
    String empname;
    String seniority;
    String empdate;
    Double points;

    public Employee(int empid, String empname, String seniority, String empdate) {
        this.empid = empid;
        this.empname = empname;
        this.seniority = seniority;
        this.empdate = empdate;
    }


    public Employee(int empid, String empname, String seniority, String empdate,Double points) {
        this.empid = empid;
        this.empname = empname;
        this.seniority = seniority;
        this.empdate = empdate;
        this.points = points;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getEmpdate() {
        return empdate;
    }

    public void setEmpdate(String empdate) {
        this.empdate = empdate;
    }
}
