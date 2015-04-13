package com.example.student.assignment;

/**
 * Created by student on 3/29/15.
 */
public class Student {
    public int _id;
    public String destination = "";
    public String Q1_13 = "" ;
    public String Q2_13 = "";
    public String Q3_13 = "";
    public String Q4_13 = "";

    public String Q1_14 = "";
    public String Q2_14 = "";
    public String Q3_14 = "";




    public int getID() {
        return this._id;
    }

    public void setID(int id) {

        this._id = id;
    }


    public String getDestination() {
        return destination;
    }
    public void setDestination(String d) {
        this.destination = d;
    }


    public String getQ1_13() {
        return Q1_13;
    }
    public void setQ1_13(String num) {
        this.Q1_13 = num;
    }

    public String getQ2_13() {
        return Q2_13;
    }
    public void setQ2_13(String num) {
        this.Q2_13 = num;
    }


    public String getQ3_13() {
        return Q3_13;
    }
    public void setQ3_13(String num) {
        this.Q3_13 = num;
    }


    public String getQ4_13() {
        return Q4_13;
    }
    public void setQ4_13(String num) {
        this.Q4_13 = num;
    }


    public String getQ1_14() {
        return Q1_14;
    }
    public void setQ1_14(String num) {
        this.Q1_14 = num;
    }


    public String getQ2_14() {
        return Q2_14;
    }
    public void setQ2_14(String num) {
        this.Q2_14 = num;
    }


    public String getQ3_14() {
        return Q3_14;
    }
    public void setQ3_14(String num) {
        this.Q3_14 = num;
    }


    // constructor
    public Student(int id, String d,String n1 ,String n2,String n3, String n4 , String n5, String n6, String n7){
        this._id = id;
        this.destination = d;
        this.Q1_13 = n1;
        this.Q2_13 = n2;
        this.Q3_13 = n3;
        this.Q4_13 = n4;

        this.Q1_14 = n5;
        this.Q2_14 = n6;
        this.Q3_14 = n7;
    }


    @Override
    public String toString() {
        return Q1_13 + "\n" +  Q2_13 + "\n" + Q3_13 + "\n" + Q4_13 + "\n" +  Q1_14 + "\n" + Q2_14 + "\n" + Q3_14;
    }
    public Student(){

    }
}
