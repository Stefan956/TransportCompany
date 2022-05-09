package dao;

import configuration.SessionFactoryUtil;
import model.Client;
import model.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDAO {

    public static void saveVehicle (Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    public static void saveOrUpdateVehicle (Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    public static Vehicle getVehicle (int id) {
        Transaction transaction = null;
        Vehicle vehicle;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            vehicle = session.get(Vehicle.class, id);
            transaction.commit();
        }
        return vehicle;
    }

    public static void saveVehicles (List<Vehicle> vehicleList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicleList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Vehicle> getVehicles() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Vehicle a", Vehicle.class).list();
        }
    }

    public static Vehicle loadVehicle (int id) {
        Transaction transaction = null;
        Vehicle vehicle;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            vehicle = session.load(Vehicle.class, id);
            transaction.commit();
        }
        return vehicle;
    }

    public static Vehicle getVehicleById(int id) {
        Transaction transaction = null;
        Vehicle vehicle;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            vehicle = session.byId(Vehicle.class).getReference(id);
            transaction.commit();
        }
        return vehicle;
    }

    public static void deleteVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }
}
