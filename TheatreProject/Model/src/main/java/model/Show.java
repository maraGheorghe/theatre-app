package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@javax.persistence.Entity
@Table(name = "shows")
public class Show extends Entity {
    private String name;
    private LocalDateTime date;
    private String description;

    public Show() {}

    public Show(String name, LocalDateTime date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Show(Long id, String name, LocalDateTime date, String description) {
        setID(id);
        this.name = name;
        this.date = date;
        this.description = description;
    }

    @Id
    @Column(name = "show_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Override
    public Long getID() {
        return super.getID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "\"" + name + "\"" +  "   " + date.format(format) + "   " + description;
    }
}
