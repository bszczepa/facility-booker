package com.student.facilityBooking.controllers;

import com.student.facilityBooking.model.Activities;
import com.student.facilityBooking.persistence.ActivitiesService;
import com.student.facilityBooking.persistence.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/api/activities")
public class ActivitiesRestController {
    @Autowired
    ActivitiesService activitiesService;

    @Autowired
    FacilityService facilityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        Collection<Activities> activities = activitiesService.getAll();
        return new ResponseEntity<Collection<Activities>>(activities, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable("id") String name) {
        Activities activities = activitiesService.findByName(name);
        if (activities == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Activities>(activities, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> addActivity(@RequestBody Activities activities) {
        if (activitiesService.findByName(activities.getName()) != null) {
            return new ResponseEntity(
                    "Activity " + activities.getName() + " already exists.",
                    HttpStatus.CONFLICT);
        }
        activitiesService.add(activities);
        return new ResponseEntity<Activities>(activities, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") String name) {
        Activities activities = activitiesService.findByName(name);
        if (activities == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        activitiesService.delete(activities);
        return new ResponseEntity<Activities>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") String name,
                                    @RequestBody Activities updatedActivity) {
        if (activitiesService.findByName(name) != null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        updatedActivity.setName(name); // in case of login!=updatedParticipant.getLogin()
        activitiesService.update(updatedActivity);
        return new ResponseEntity<Activities>(HttpStatus.NO_CONTENT);
    }
}
