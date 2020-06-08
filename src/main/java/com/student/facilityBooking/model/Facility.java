package com.student.facilityBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="facilities")

public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    Set<Activities> activities;


    @Column
    private String name;

//    public long getActivityId() { return activityId; }

    public long getId() { return id; }

    public Set<Activities> getActivities() { return  activities; }

    public  String getName() { return name; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

//    public void setActivityId(long id) { this.activityId = id; }

}
// opis, adres, adres zdjęcia, żeby dodać zdjęcie obiektu, adres zdjęcia w stringu