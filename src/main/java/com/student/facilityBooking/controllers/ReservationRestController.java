package com.student.facilityBooking.controllers;

import com.student.facilityBooking.model.Activities;
import com.student.facilityBooking.persistence.ActivitiesService;
import com.student.facilityBooking.model.Facility;
import com.student.facilityBooking.model.Reservation;
import com.student.facilityBooking.persistence.ActivitiesService;
import com.student.facilityBooking.persistence.FacilityService;
import com.student.facilityBooking.persistence.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

    @Autowired
    FacilityService facilityService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ActivitiesService activitiesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        Collection<Reservation> reservations = reservationService.getAll();
        return new ResponseEntity<Collection<Reservation>>(reservations, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> saveResource(@RequestBody Reservation reservation, @PathVariable("id") long id){
        reservationService.save(reservation);
        return ResponseEntity.ok("Resource saved");
    }


    }