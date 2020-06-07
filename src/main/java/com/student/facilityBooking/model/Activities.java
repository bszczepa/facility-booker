package com.student.facilityBooking.model;

import javax.persistence.*;

@Entity
@Table(name = "activities")

public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private long facilityId;

    public long getId() { return  id; }

    public String getName() { return name; }

    public long getFacilityId() { return facilityId; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setFacilityId(long facilityId) { this.facilityId = facilityId; }

}
