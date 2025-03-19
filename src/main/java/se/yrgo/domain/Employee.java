package se.yrgo.domain;

import jakarta.persistence.*;

/**
 * This class represents an employee.
 * Objects of this class can be added to an employer-object.
 * But only the employer keeps track of the employees.
 * We can however retrieve a list of employees by referencing an employer in main.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String address;

    private int age;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
