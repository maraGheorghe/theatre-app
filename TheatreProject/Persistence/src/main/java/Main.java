import model.Manager;
import model.Seat;
import model.Show;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Main {
    private static SessionFactory sessionFactory;

    static void initialize() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.err.println("Exceptie: " + e);
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    static void close() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public static void main(String ... arg) {
        initialize();
        try(Session session = sessionFactory.openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                var show = session.createQuery("from Show as p where p.date >= :date1 and p.date <= :date2", Show.class)
                        .setParameter("date1", LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)))
                        .setParameter("date2", LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59)))
                        .setMaxResults(1)
                        .uniqueResult();
                System.out.println(show);
                tx.commit();
            } catch(RuntimeException ex){
                if (tx != null)
                    tx.rollback();
            }
        }
        close();
    }
}
