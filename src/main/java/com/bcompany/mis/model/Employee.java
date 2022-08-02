package com.bcompany.mis.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(name = "firstname", length = 100, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 100, nullable = false)
    private String lastName;
    @Column(name = "telephone", length = 50, nullable = false, unique = true)
    private String telePhone;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 128, nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dob;
    @Transient
    private int age;
    @Column(length = 10, nullable =
            false)
    private String gender;
    @ManyToOne
    @JoinColumn(name = "dId", nullable = false)
    private Department department;

    public Employee(String firstName, String lastName, String telePhone, String email, String username, String password, LocalDate dob, String gender, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telePhone = telePhone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.department = department;
    }

    public Employee() {
    }

    public Employee(String firstName, String lastName, String telePhone, String email, String username, String password, LocalDate dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telePhone = telePhone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        int age = 0;
        if (this.dob != null) {
            age = Period.between(this.dob, LocalDate.now()).getYears();
        }
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return super.toString();
    }
}
