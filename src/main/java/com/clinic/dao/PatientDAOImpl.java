package com.clinic.dao;

import com.clinic.model.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPatient(Patient patient) {
        this.entityManager.persist(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        this.entityManager.merge(patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> listPatients() {
        List<Patient> patientlist = this.entityManager.createQuery("SELECT pat FROM Patient pat ORDER BY pat.profile.name").getResultList();

        return patientlist;
    }

    @Override
    public Patient getPatientById(int id) {
        return this.entityManager.find(Patient.class, id);
    }

    @Override
    public void removePatient(int id) {
        Patient patient = this.getPatientById(id);
        if (null != patient) {
            this.entityManager.remove(patient);
        }
    }
}
