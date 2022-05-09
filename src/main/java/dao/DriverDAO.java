package dao;

import configuration.SessionFactoryUtil;
import model.Client;
import model.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DriverDAO {

    public static void saveDriver(Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDriver (Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static Driver getDriver(int id) {
        Transaction transaction = null;
        Driver driver;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            driver = session.get(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static void saveDrivers(List<Driver> driverList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driverList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Driver> getDrivers() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Driver a", Driver.class).list();
        }
    }

    public static Driver loadDriver (int id) {
        Transaction transaction = null;
        Driver driver;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            driver = session.load(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static Driver getDriverById (int id) {
        Transaction transaction = null;
        Driver driver;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            driver = session.byId(Driver.class).getReference(id);
            transaction.commit();
        }
        return driver;
    }

    public static List<Driver> driversBySalaryAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> driverList = query.getResultList();
            return driverList;
        }
    }

    public static void deleteDriver (Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(driver);
            transaction.commit();
        }
    }
}
