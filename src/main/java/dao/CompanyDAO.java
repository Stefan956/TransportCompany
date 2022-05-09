package dao;

import configuration.SessionFactoryUtil;
import dto.*;
import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CompanyDAO {

    public static void saveCompany(model.Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCompany(model.Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void saveCompanies(List<Company> companyList) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companyList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Company> readCompanies() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM model.Company c", model.Company.class).getResultList();
        }
    }

    public static model.Company getCompany(int id) {
        model.Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // get Company entity using get() method
            company = session.get(model.Company.class, id);
//            company = session.createQuery(
//                            "select c from Company c" +
//                                    " where c.id = :id",
//                            Company.class)
//                    .setParameter("id", id)
//                    .getSingleResult();
            transaction.commit();
        }
        return company;
    }

    public static List<Client> getCompanyClients(int id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.clients" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getClients();
    }

    public static List<ClientDTO> getCompanyClientsDTO(int id) {
        List<ClientDTO> clients;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients = session.createQuery(
                            "select new dto.ClientDTO(e.id, e.firstName, e.lastName, e.hasPaid) from Client e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            ClientDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return clients;
    }

    public static List<Driver> getCompanyDrivers(int id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.drivers" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getDrivers();
    }

    public static List<DriverDTO> getCompanyDriversDTO(int id) {
        List<DriverDTO> drivers;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            drivers = session.createQuery(
                            "select new dto.DriverDTO(e.id, e.firstName, e.lastName, e.qualification, e.salary) from Driver e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            DriverDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return drivers;
    }

    public static List<Vehicle> getCompanyVehicles(int id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.vehicles" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getVehicles();
    }

    public static List<VehicleDTO> getCompanyVehiclesDTO(int id) {
        List<VehicleDTO> vehicles;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicles = session.createQuery(
                            "select new dto.VehicleDTO(e.id, e.plate, e.vehicleType) from Vehicle e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            VehicleDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return vehicles;
    }

    public static List<Trip> getCompanyTrips(int id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.trips" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getTrips();
    }

    public static List<TripDTO> getCompanyTripsDTO(long id) {
        List<TripDTO> trips;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            trips = session.createQuery(
                            "select new dto.TripDTO(e.id, e.originPoint, e.destinationPoint," +
                                    " e.departureDate ,e.arrivalDate, e.weight, e.price ) from Trip e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            TripDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return trips;
    }

    public static List<Company> companiesByNameAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.orderBy(cb.asc(root.get("name")));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static model.Company loadCompany(int id) {
        Transaction transaction = null;
        model.Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            company = session.load(model.Company.class, id);
            transaction.commit();
        }
        return company;
    }

    public static model.Company getCompanyById(int id) {
        Transaction transaction = null;
        model.Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            company = session.byId(model.Company.class).getReference(id);
            transaction.commit();
        }
        return company;
    }

    public static void deleteCompany(model.Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }
}
