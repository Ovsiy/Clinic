package com.clinic.service;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Patient;

import java.util.List;

public interface PatientService {
    public void addPatient(Patient patient) throws DublicateEmailException;
    public void updatePatient(Patient patient);
    public List<Patient> listPatients();
    public Patient getPatientById(int id);
    public void removePatient(int id);
}
