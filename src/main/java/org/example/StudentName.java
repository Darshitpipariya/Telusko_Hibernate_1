package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentName {
    private String f_name;
    private String m_name;
    private String l_name;

    public StudentName() {
    }

    public StudentName(String f_name, String m_name, String l_name) {
        this.f_name = f_name;
        this.m_name = m_name;
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    @Override
    public String toString() {
        return "StudentName{" +
                "f_name='" + f_name + '\'' +
                ", m_name='" + m_name + '\'' +
                ", l_name='" + l_name + '\'' +
                '}';
    }
}
