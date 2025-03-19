package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an employer.
 * It has a unidirectional One-To-Many relationship to employees.
 * The Employer-ID will be added as a foreign key in the Employee-table.
 */
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id; // ID is a long.

    @Column(length = 20) // Shortened length for readability in the terminal.
    private String companyName;

    @Column(length = 20)
    private String address;

    @OneToMany
    @JoinColumn(name = "EMPLOYER_FK") // Adds a FK in the employee-table
    private List<Employee> employees;

    public Employer() {}

    public Employer(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>(); // Initiates an array-list
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * This method adds an employee to an employer
     * @param employee is the person (employee-object) that will be added to the employer
     */
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                '}';
    }
}
