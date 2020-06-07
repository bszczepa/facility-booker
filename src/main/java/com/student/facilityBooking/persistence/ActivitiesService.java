package com.student.facilityBooking.persistence;

import com.student.facilityBooking.model.Activities;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("activitiesService")
public class ActivitiesService {
   DatabaseConnector connector;

   public ActivitiesService() { connector = DatabaseConnector.getInstance(); }

   public Collection<Activities> getAll() {
       String hql = "FROM Activities";
       Query query = connector.getSession().createQuery(hql);
       return query.list();
   }
}
