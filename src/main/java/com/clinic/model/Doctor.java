package com.clinic.model;

import com.clinic.validators.Phone;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 255)
    @Size(min=2, max=255)
    private String name;

    @Column(name = "surname", length = 255, nullable = false)
    @Size(min=2, max=255)
    private String surname;

    @Column(name = "email", length = 255, nullable = false)
    @Email
    @Size(min=2, max=255)
    private String email;

    @Column(name = "phone", length = 64)
    @Phone
    private String phone;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @Override
    public String toString() {
        return this.getClass().toString() +
                "id " + this.id +
                " name " + this.name +
                "surname " + this.surname +
                " email " + this.email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    @PrePersist
    public void prepersist() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    @PreUpdate
    public void preupdate() {
        this.updated_at = new Date();
    }
}
