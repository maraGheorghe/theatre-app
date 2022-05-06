package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "seats")
public class Seat extends Entity {
    private int row;
    private int box;
    private int number;
    private int price;

    public Seat() {}

    public Seat(int row, int box, int number, int price) {
        this.row = row;
        this.box = box;
        this.number = number;
        this.price = price;
    }

    public Seat(Long id, int row, int box, int number, int price) {
        setID(id);
        this.row = row;
        this.box = box;
        this.number = number;
        this.price = price;
    }

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Override
    public Long getID() {
        return super.getID();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        if (box != -1)
            return "box: " + box
            + "\nrow: " + row
            + "\nnumber: " + number
            + "\nprice: " + price;
        else return "row: " + row
                + "\nnumber: " + number
                + "\nprice: " + price;
    }
}
