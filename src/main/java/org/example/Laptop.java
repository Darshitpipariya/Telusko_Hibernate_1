package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    public Laptop(int lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    @Id
    @Column(name = "lid")
    private int lid;

    @Column(name="lname")
    private String lname;

    public Laptop() {
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }
}
