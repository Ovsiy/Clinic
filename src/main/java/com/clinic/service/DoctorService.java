package com.clinic.service;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Doctor;

import java.util.List;

public interface DoctorService {
    public void addDoctor(Doctor doctor) throws DublicateEmailException;
    public void updateDoctor(Doctor doctor);
    public List<Doctor> listDoctors();
    public Doctor getDoctorById(int id);
    public void removeDoctor(int id);
}
