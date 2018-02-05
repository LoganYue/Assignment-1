package com.example.ltyue.assignment1;

import java.util.Date;

/**
 * Created by ltyue on 1/26/18.
 */

public class Subscription {

    private String name;
    private String date;
    private double cost;
    private String comment = "";

    //default constructor
    public Subscription(String subName, String date, double cost){
        this.name = subName;
        this.date = date;
        this.cost = cost;
    }

    //constructor w/ comment
    public Subscription(String subName, String date, double cost, String comment){
        this.name = subName;
        this.date = date;
        this.cost = cost;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    @Override
    public String toString() {
        if (comment != ""){

            return "Name: " + this.name + '\n' + "Cost: " + this.cost + '\n' +
                    "Date: " + this.date + '\n' + this.comment;
        } else {

            return "Name: " + this.name + '\n' + "Cost: " + this.cost + '\n' + "Date: " + this.date;

        }
    }
}
