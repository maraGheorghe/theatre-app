package model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "reservation")
public class Reservation extends Entity {
    private String firstName;
    private String lastName;
    private String email;
    private int telephone;
    private Show show;
    private List<Seat> seats;

    public Reservation() {}

    public Reservation(String firstName, String lastName, String email, int telephone, Show show, List<Seat> seats) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.show = show;
        this.seats = seats;
    }

    public Reservation(Long id, String firstName, String lastName, String email, int telephone, Show show, List<Seat> seats) {
        setID(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.show = show;
        this.seats = seats;
    }

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Override
    public Long getID() {
        return super.getID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @ManyToOne
    @JoinColumn(name = "show_id")
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @ManyToMany()
    @JoinTable( name = "reservation_seats",
                joinColumns = { @JoinColumn(name = "reservation_id") },
                inverseJoinColumns = { @JoinColumn(name = "seat_id") } )
    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Reservation { " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", show=" + show +
                ", seats=" + seats +
                " }";
    }
}
