package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<Student> students=new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Laptop(int lid, String lname, List<Student> students) {
        this.lid = lid;
        this.lname = lname;
        this.students = students;
    }
}
