package dao;

import configuration.SessionFactoryUtil;
import model.Cargo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CargoDAO {

    public static void saveCargo (Cargo cargo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cargo);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCargo(Cargo cargo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(cargo);
            transaction.commit();
        }
    }

    public static Cargo getCargo(int id) {
        Transaction transaction = null;
        Cargo cargo;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            cargo = session.get(Cargo.class, id);
            transaction.commit();
        }
        return cargo;
    }

    public static void saveCargoList (List<Cargo> cargoList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            cargoList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Cargo> getCargoList() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Cargo a", Cargo.class).list();
        }
    }

    public static Cargo loadCargo (int id) {
        Transaction transaction = null;
        Cargo cargo;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            cargo = session.load(Cargo.class, id);
            transaction.commit();
        }
        return cargo;
    }

    public static Cargo getCargoByID(int id) {
        Transaction transaction = null;
        Cargo cargo;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            cargo = session.byId(Cargo.class).getReference(id);
            transaction.commit();
        }
        return cargo;
    }

    public static void deleteMerch (Cargo cargo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cargo);
            transaction.commit();
        }
    }
}
