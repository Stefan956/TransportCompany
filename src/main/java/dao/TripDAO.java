package dao;

import configuration.SessionFactoryUtil;

import model.Trip;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TripDAO {

    public static void saveTrip (Trip trip) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(trip);
            transaction.commit();
        }
    }

    public static void saveOrUpdateTrip (Trip trip) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(trip);
            transaction.commit();
        }
    }

    public static Trip getTrip (int id) {
        Transaction transaction = null;
        Trip trip;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            trip = session.get(Trip.class, id);
            transaction.commit();
        }
        return trip;
    }

    public static void saveTrips (List<Trip> tripList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            tripList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Trip> getTrips() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Trip a", Trip.class).list();
        }
    }

    public static Trip loadTrip (int id) {
        Transaction transaction = null;
        Trip trip;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            trip = session.load(Trip.class, id);
            transaction.commit();
        }
        return trip;
    }

    public static Trip getTripById (int id) {
        Transaction transaction = null;
        Trip trip;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            trip = session.byId(Trip.class).getReference(id);
            transaction.commit();
        }
        return trip;
    }

    public static List<Trip> tripsWithDestinationEqualTo(String destinationPoint) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Trip> cr = cb.createQuery(Trip.class);
            Root<Trip> root = cr.from(Trip.class);
            cr.select(root).where(cb.equal(root.get("destinationPoint"), destinationPoint));

            Query<Trip> query = session.createQuery(cr);
            List<Trip> tripList = query.getResultList();
            return tripList;
        }
    }

    public static void deleteTrip (Trip trip) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(trip);
            transaction.commit();
        }
    }
}
