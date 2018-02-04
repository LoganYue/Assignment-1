package com.example.ltyue.assignment1;

import java.util.Date;

/**
 * Created by ltyue on 1/26/18.
 */

public class Subscription {

    private String sub_name;
    private String date;
    private int cost;
    private String comment;

    //default constructor
    public Subscription(String sub_name, String date, int cost){
        this.sub_name = sub_name;
        this.date = date;
        this.cost = cost;
    }

    //constructor w/ comment
    public Subscription(String sub_name, String date, int cost, String comment){
        this.sub_name = sub_name;
        this.date = date;
        this.cost = cost;
        this.comment = comment;
    }
    public String getSub_name(){
        return this.sub_name;
    }

    public String getDate(){
        return this.date;
    }

    public int getCost(){
        return this.cost;
    }

    public String getComment(){
        return this.comment;
    }

    public void changeName(String name){
        this.sub_name = name;
        return;
    }

    public void changeDate(String date){
        this.date = date;
        return;
    }

    public void changeCost(int cost){
        this.cost = cost;
        return;
    }

    public void changeComment(String comment){
        this.comment = comment;
        return;
    }
}
