package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "managers")
public class Manager extends model.Entity {
    private String username;
    private String password;

    public Manager() {}

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager(Long id, String username, String password) {
        setID(id);
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "manager_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Override
    public Long getID() {
        return super.getID();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager { " +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                " }";
    }
}
