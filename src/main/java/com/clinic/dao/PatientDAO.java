package com.clinic.dao;

import com.clinic.model.Patient;

import java.util.List;

public interface PatientDAO {
    public void addPatient(Patient patient);
    public void updatePatient(Patient patient);
    public List<Patient> listPatients();
    public Patient getPatientById(int id);
    public void removePatient(int id);
}
