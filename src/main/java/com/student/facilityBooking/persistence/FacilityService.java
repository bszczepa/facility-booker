package com.student.facilityBooking.persistence;

import com.student.facilityBooking.model.Facility;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("facilityService")
public class FacilityService {
    DatabaseConnector connector;

    public FacilityService() { connector = DatabaseConnector.getInstance(); }

    public Collection<Facility> getAll() {
        String hql = "FROM Facility";
        Query query = connector.getSession().createQuery(hql);
        return query.list();
    }
}
