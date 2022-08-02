package com.bcompany.mis.model;
import javax.persistence.*;
import java.util.Date;
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
    @Column(name = "telephone", length = 10, nullable = false, unique = true)
    private String telePhone;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 128, nullable = false)
    private String password;
    @Column(nullable = false)
    private Date dob;
    @Column(length = 10, nullable = false)
    private String gender;


    public Employee() {}

    public Employee(String firstName, String lastName, String telePhone, String email, String username, String password, Date dob, String gender) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return super.toString();
    }
}
