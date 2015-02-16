package com.clinic.dao;

import com.clinic.model.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

//    We could use session factory, but than can't use pre-persist, pre-update'
//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void addDoctor(Doctor doctor) {
//        Session session = entityManager.unwrap(Session.class);
//        session.persist(doctor);
//        session.flush();
//    }

    @Override
    public Doctor getDoctorById(int id) {
        return this.entityManager.find(Doctor.class, id);
    }

    @Override
    public void addDoctor(Doctor doctor) {
       this.entityManager.persist(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        this.entityManager.merge(doctor);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Doctor> listDoctors() {
        List<Doctor> doctorsList = this.entityManager.createQuery("SELECT doc FROM Doctor doc ORDER BY doc.profile.name").getResultList();

        return doctorsList;
    }

    @Override
    public void removeDoctor(int id) {
        Doctor doctor = this.getDoctorById(id);
        if (null != doctor) {
            this.entityManager.remove(doctor);
        }
    }
}
