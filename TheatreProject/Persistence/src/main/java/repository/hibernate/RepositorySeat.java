package repository.hibernate;

import model.Seat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.SessionFactoryUtil;
import repository.interfaces.RepositorySeatInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorySeat implements RepositorySeatInterface {
    @Override
    public Optional<Seat> save(Seat entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Seat> find(Long ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Seat> delete(Seat entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Seat> update(Seat entity) {
        return Optional.empty();
    }

    @Override
    public List<Seat> findAll() {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                List<Seat> seats = session.createQuery("from Seat as s", Seat.class).list();
                tx.commit();
                return seats;
            } catch(RuntimeException ex){
                if (tx != null)
                    tx.rollback();
                return new ArrayList<>();
            }
        }
    }
}
