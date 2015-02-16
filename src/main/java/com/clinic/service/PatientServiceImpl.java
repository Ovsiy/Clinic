package com.clinic.service;

import com.clinic.dao.PatientDAO;
import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addPatient(Patient patient) throws DublicateEmailException{
        try {
            this.patientDAO.addPatient(patient);
        }
        catch(Exception e) {
            throw new DublicateEmailException();
        }
    }

    @Transactional
    @Override
    public void updatePatient(Patient patient) {
        this.patientDAO.updatePatient(patient);
    }

    @Transactional
    @Override
    public List<Patient> listPatients() {
        return this.patientDAO.listPatients();
    }

    @Transactional
    @Override
    public Patient getPatientById(int id) {
        return this.patientDAO.getPatientById(id);
    }

    @Transactional
    @Override
    public void removePatient(int id) {
        this.patientDAO.removePatient(id);
    }
}
