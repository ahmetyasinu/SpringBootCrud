package com.devau.travel.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="travel")
public class Traveller {
    @Column(name = "destination")
    private String destination;
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "projectCode")
    private String projectCode;
    @Column(name = "cost")
    private int cost;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "endDate")
    private String endDate;
    @Column(name = "userName")
    private String userName;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    public  Traveller(){

    }


        public Traveller(String destination, String purpose, String projectCode, int cost, String startDate, String endDate, String userName,int id) {
        this.destination = destination;
        this.purpose = purpose;
        this.projectCode = projectCode;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userName = userName;
        this.id=id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String  getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Traveller{" +
                "destination='" + destination + '\'' +
                ", purpose='" + purpose + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", cost=" + cost +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
