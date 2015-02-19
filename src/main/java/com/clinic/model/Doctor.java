package com.clinic.model;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
    private Set<Patient> patients = new HashSet<Patient>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public String getFullName() {
        return "Dr. " + this.profile.getName() + " " + this.profile.getSurname();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", profile=" + profile.toString() +
                ", patients=" + patients +
                '}';
    }
}
