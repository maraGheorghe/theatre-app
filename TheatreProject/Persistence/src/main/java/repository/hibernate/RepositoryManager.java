package repository.hibernate;

import model.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.SessionFactoryUtil;
import repository.interfaces.RepositoryManagerInterface;

import java.util.List;
import java.util.Optional;

public class RepositoryManager implements RepositoryManagerInterface {
    @Override
    public Optional<Manager> save(Manager entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Manager> find(Long ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Manager> delete(Manager entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Manager> update(Manager entity) {
        return Optional.empty();
    }

    @Override
    public List<Manager> findAll() {
        return null;
    }

    @Override
    public Optional<Manager> checkConnection(String username, String password) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Manager manager = session.createQuery("from Manager as m where m.username = :username and m.password = :password", Manager.class)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
                return Optional.ofNullable(manager);
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }
}
