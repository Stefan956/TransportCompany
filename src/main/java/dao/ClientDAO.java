package dao;

import configuration.SessionFactoryUtil;
import model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO {

    public static void saveClient(model.Client client) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public static void saveOrUpdateClient(model.Client client) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

    public static model.Client getClient(int id) {
        Transaction transaction = null;
        model.Client client;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using get() method
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }

    public static void saveClients(List<Client> clientList) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clientList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Client> getClients() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Client a", Client.class).list();
        }
    }

    public static model.Client loadClient(int id) {
        Transaction transaction = null;
        model.Client client;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using load() method
            client = session.load(Client.class, id);
            transaction.commit();
        }
        return client;
    }

    public static model.Client getClientById(int id) {
        Transaction transaction = null;
        model.Client client;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get Company entity using byId() method
            client = session.byId(Client.class).getReference(id);
            transaction.commit();
        }
        return client;
    }

    public static void deleteClient(model.Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
}
