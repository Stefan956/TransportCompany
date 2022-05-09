package dao;

import configuration.SessionFactoryUtil;
import model.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PassengerDAO {

    public static void savePassenger (Passenger passenger) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(passenger);
            transaction.commit();
        }
    }

    public static void saveOrUpdatePassenger (Passenger passenger) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(passenger);
            transaction.commit();
        }
    }

    public static Passenger getPassenger (int id) {
        Transaction transaction = null;
        Passenger passenger;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            passenger = session.get(Passenger.class, id);
            transaction.commit();
        }
        return passenger;
    }

    public static void savePassengers (List<Passenger> passengerList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            passengerList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Passenger> getPassengers() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Passenger a", Passenger.class).list();
        }
    }

    public static Passenger loadPassenger (int id) {
        Transaction transaction = null;
        Passenger passenger;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            passenger = session.load(Passenger.class, id);
            transaction.commit();
        }
        return passenger;
    }

    public static Passenger getPassengerById (int id) {
        Transaction transaction = null;
        Passenger passenger;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            passenger = session.byId(Passenger.class).getReference(id);
            transaction.commit();
        }
        return passenger;
    }

    public static void deletePassenger (Passenger passenger) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(passenger);
            transaction.commit();
        }
    }
}
