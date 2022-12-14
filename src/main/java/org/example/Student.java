package org.example;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student{


    public Student() {
    }

    @Column(name = "s_name")
    private StudentName name;
    @Id
    @Column(name = "rollno",unique = true,nullable = false)
    private String rollnum;
    @Column(name="grade")
    private String Grade;
    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    private List<Laptop> laptop_list=new ArrayList<>();

    public Student(StudentName name, String rollnum, String grade) {
        this.name = name;
        this.rollnum = rollnum;
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", rollnum='" + rollnum + '\'' +
                ", Grade='" + Grade + '\'' +
                ", laptop_list=" + laptop_list +
                '}';
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public String getRollnum() {
        return rollnum;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public List<Laptop> getLaptop_list() {
        return laptop_list;
    }

    public void setLaptop_list(List<Laptop> laptop_list) {
        this.laptop_list = laptop_list;
    }
}
