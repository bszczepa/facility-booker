package com.student.facilityBooking.persistence;

import com.student.facilityBooking.model.Activities;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.Collection;

@Component("activitiesService")
public class ActivitiesService {
   DatabaseConnector connector;

   public ActivitiesService() { connector = DatabaseConnector.getInstance(); }

    public Collection<Activities> getAll() {
        return connector.getSession().createCriteria(Activities.class).list();
    }

    public Activities findById(long id) {
        return (Activities) connector.getSession().get(Activities.class, id);
    }

    public Activities add(Activities activities) {
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().save(activities);
        transaction.commit();
        return activities;
    }

    public void update(Activities activities) {
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().merge(activities);
        transaction.commit();
    }

    public void delete(Activities activities) {
        Transaction transaction = connector.getSession().beginTransaction();
        connector.getSession().delete(activities);
        transaction.commit();
    }
}
