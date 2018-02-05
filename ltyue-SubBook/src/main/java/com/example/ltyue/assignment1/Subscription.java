/*
 * Copyright (c) Logan Yue February 2018
 */

package com.example.ltyue.assignment1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Subscription class holds subscription information
 *
 * @author Logan Yue
 * @see MainActivity
 */

public class Subscription {

    private String name;
    private Date date;
    private double cost;
    private String comment = "";

    /**
     * constructs a subsciption object
     *
     * @param subName sub name
     * @param date sub date
     * @param cost sub cost
     */
    //default constructor
    public Subscription(String subName, Date date, double cost){
        this.name = subName;
        this.date = date;
        this.cost = cost;
    }

    /**
     * constructs a subscription object with a non-default comment
     *
     * @param subName
     * @param date
     * @param cost
     * @param comment sub comment
     */
    //constructor w/ comment
    public Subscription(String subName, Date date, double cost, String comment){
        this.name = subName;
        this.date = date;
        this.cost = cost;
        this.comment = comment;
    }

    /**
     * returns the sub name
     * @return sub name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the sub name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the sub date as a string
     * @return sub date (String)
     */
    public String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = df.format(this.date);
        return stringDate;
    }

    /**
     * sets the sub date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * returns the sub cost
     * @return sub cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * sets the sub cost
     *
     * @param cost sub cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * returns the sub comment
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     * sets a new sub comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * sets a string representation of the subscription to be displayed by ListView
     * @return
     */
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
