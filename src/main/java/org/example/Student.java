package org.example;
import jakarta.persistence.*;
@Entity
@Table(name = "student")
public class Student{


    public Student() {
    }

    @Column(name = "s_name")
    private StudentName name;
    @Id
    @Column(name = "rolln0",unique = true,nullable = false)
    private String rollnum;
    @Column(name="grade")
    private String Grade;


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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollnum='" + rollnum + '\'' +
                ", Grade='" + Grade + '\'' +
                '}';
    }
}
