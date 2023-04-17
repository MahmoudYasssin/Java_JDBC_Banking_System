package org.example.jdbcuniversity.model;

public class Student {
    private  int id;
    private  String name;
    private double GPA;
    private String department;
    private  String status;

    public Student() {
    }

    public Student(int id, String name, double GPA, String department, String status) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", GPA=" + GPA +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
