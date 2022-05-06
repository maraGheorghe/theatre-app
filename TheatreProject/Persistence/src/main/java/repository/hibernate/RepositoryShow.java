package repository.hibernate;

import model.Reservation;
import model.Seat;
import model.Show;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.SessionFactoryUtil;
import repository.interfaces.RepositoryShowInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RepositoryShow implements RepositoryShowInterface {
    @Override
    public Optional<Show> save(Show entity) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(entity);
                tx.commit();
                return Optional.of(entity);
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }

    @Override
    public Optional<Show> find(Long ID) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Show show = session.createQuery("from Show where ID = :id", Show.class)
                        .setParameter("id", ID)
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
                return Optional.of(show);
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }

    @Override
    public Optional<Show> delete(Show entity) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                Show show = session.load(Show.class, entity.getID());
                session.delete(show);
                tx.commit();
                return Optional.of(entity);
            } catch(RuntimeException ex){
                if (tx!=null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }

    @Override
    public Optional<Show> update(Show entity) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Show show = session.load(Show.class, entity.getID());
                show.setDate(entity.getDate());
                show.setName(entity.getName());
                show.setDescription(entity.getDescription());
                tx.commit();
                return Optional.of(entity);
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }

    @Override
    public List<Show> findAll() {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                List<Show> shows = session.createQuery("from Show as s", Show.class).list();
                tx.commit();
                return shows;
            } catch(RuntimeException ex){
                if (tx != null)
                    tx.rollback();
                return new ArrayList<>();
            }
        }
    }

    @Override
    public List<Seat> findReservedSeats(Long id) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                Show show = session.load(Show.class, id);
                List<Reservation> reservations = session.createQuery("from Reservation where show = :show", Reservation.class)
                        .setParameter("show", show).list();
                List<Seat> seats = reservations.stream().map(r -> r.getSeats().stream()).reduce(Stream::concat).get().toList();
                tx.commit();
                return seats;
            } catch(RuntimeException ex){
                if (tx != null)
                    tx.rollback();
                return new ArrayList<>();
            }
        }
    }

    @Override
    public Optional<Show> getShowOfADay(LocalDate date) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Show show = session.createQuery("from Show as s where s.date >= :date1 and s.date <= :date2", Show.class)
                        .setParameter("date1", LocalDateTime.of(date, LocalTime.of(0, 0)))
                        .setParameter("date2", LocalDateTime.of(date, LocalTime.of(23, 59)))
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
                return Optional.ofNullable(show);
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                return Optional.empty();
            }
        }
    }
}
