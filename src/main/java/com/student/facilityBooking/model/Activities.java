package com.student.facilityBooking.model;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="activityId")
    Set<Reservation> reservations;

    public long getId() { return  id; }

    public String getName() { return name; }

    public Set<Reservation> getReservations() { return reservations; }

    public long getFacilityId() { return facilityId; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setFacilityId(long facilityId) { this.facilityId = facilityId; }

}


// połączenia między tabelami na zasadzie meeting - participant, facility- activites i  activites reservation