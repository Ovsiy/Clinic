package com.clinic.service;

import com.clinic.dao.DoctorDAO;
import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Transactional
    @Override
    public Doctor getDoctorById(int id) {
        return this.doctorDAO.getDoctorById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addDoctor(Doctor doctor) throws DublicateEmailException{
        try {
            this.doctorDAO.addDoctor(doctor);
        }
        catch(Exception e) {
            throw new DublicateEmailException();
        }
    }

    @Transactional
    @Override
    public void updateDoctor(Doctor doctor) {
        this.doctorDAO.updateDoctor(doctor);
    }

    @Transactional
    @Override
    public List<Doctor> listDoctors() {
        return this.doctorDAO.listDoctors();
    }

    @Transactional
    @Override
    public void removeDoctor(int id) {
        this.doctorDAO.removeDoctor(id);
    }
}
