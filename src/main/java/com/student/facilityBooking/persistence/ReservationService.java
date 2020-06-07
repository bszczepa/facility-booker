package com.student.facilityBooking.persistence;

import com.student.facilityBooking.model.Reservation;
import org.hibernate.Query;

import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("reservationService")
public class ReservationService {
    DatabaseConnector connector;

    public ReservationService() { connector = DatabaseConnector.getInstance(); }

    public Collection<Reservation> getAll() { return connector.getSession().createCriteria(Reservation.class).list(); }

    public Reservation add(Reservation reservation) {
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().save(reservation);
        return reservation;
    }

    public void delete(Reservation reservation){
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().delete(reservation);
        transaction.commit();
    }

}
