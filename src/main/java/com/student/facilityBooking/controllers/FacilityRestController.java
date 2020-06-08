package com.student.facilityBooking.controllers;

import com.student.facilityBooking.model.Facility;
import com.student.facilityBooking.model.Reservation;
import com.student.facilityBooking.model.Activities;

import com.student.facilityBooking.persistence.ActivitiesService;
import com.student.facilityBooking.persistence.FacilityService;
import com.student.facilityBooking.persistence.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/facilities")
public class FacilityRestController {

    @Autowired
    FacilityService facilityService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ActivitiesService activitiesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getFacilities() {
        Collection<Facility> facilities = facilityService.getAll();
        return new ResponseEntity<Collection<Facility>>(facilities, HttpStatus.OK);
    }
}
