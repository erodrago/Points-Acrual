package com.erodev.pointsaccrual;

import java.time.LocalDate;
import java.util.Date;

public class Employee {

    int empid;
    String empname;
    String seniority;
    LocalDate empdate;

    public Employee(int empid, String empname, String seniority, LocalDate empdate) {
        this.empid = empid;
        this.empname = empname;
        this.seniority = seniority;
        this.empdate = empdate;
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

    public LocalDate getEmpdate() {
        return empdate;
    }

    public void setEmpdate(LocalDate empdate) {
        this.empdate = empdate;
    }
}
