package com.company;

public class Students {
    //declare variables
    String studentName="";
    String studentYear="";
    double studentGpa=-1;

    //constructor
    public Students(String studentName, String studentYear, double studentGpa){
        setStudentName(studentName);
        setStudentYear(studentYear);
        setStudentGPA(studentGpa);
    }

    public Students() {

    }

    //get and set
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getStudentYear(){
        return studentYear;
    }
    public void setStudentYear(String studentYear){
        this.studentYear = studentYear;
    }
    public double getStudentGpa() {
        return studentGpa;
    }
    public void setStudentGPA(double studentGpa){
        this.studentGpa = studentGpa;
    }

}



