package com.student.facilityBooking.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private java.sql.Time date;

    @Column
    private long price;

    @Column
    private long activityId;

    @Column
    private String username;

    public long getId() { return  id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //    public Activities getActivities() { return  activities;}

    public java.sql.Time getDate() { return date; }

    public long getPrice() { return price; }

//    public long getFacilityId() { return facilityId; }

    public long getActivityId() { return activityId; }


    public void setId(long id) { this.id = id; }

    public void setDate(java.sql.Time date) { this.date = date; }

    public void setPrice(long price) { this.price = price;}

//    public void setFacilityId(long facilityId) { this.facilityId = facilityId; }

    public void setActivityId(long activityId) { this.activityId = activityId; }



}
