package com.clinic;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Doctor;
import com.clinic.model.Profile;
import com.clinic.service.DoctorService;
import com.clinic.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/config/testContextConfiguration.xml",
                                    "file:src/main/webapp/WEB-INF/spring-security.xml" })
public class DoctorServiceTest {

    private Doctor doctor;

    @Autowired(required = true)
    DoctorService doctorService;

    @Autowired(required = true)
    UserService userService;

    @Before
    public void initDoctor() {
        Profile profile = new Profile();
        profile.setEmail("Seal26ster@gmail.com");
        profile.setName("Eugene");
        profile.setSurname("Ovsiy");
        profile.setPhone("45645623");

        this.doctor = new Doctor();
        this.doctor.setProfile(profile);
    }

    @Test
    public void shouldInsertUpdateDeleteDoctor() throws DublicateEmailException {

        /** Insert Doctor */
        this.doctorService.addDoctor(this.doctor);

        /** Select Doctor */
        doctor = this.doctorService.getDoctorById(1);
        assertThat(doctor).isNotNull();
        assertThat(doctor.getId()).isEqualTo(1);
        assertThat(doctor.getProfile().getCreated_at()).isNotNull();
        assertThat(doctor.getProfile().getName()).isEqualTo("Eugene");
        assertThat(doctor.getProfile().getEmail()).isEqualTo("Seal26ster@gmail.com");

        /** Update Doctor */
        doctor.getProfile().setName("Vasya");
        this.doctorService.updateDoctor(doctor);

        doctor = this.doctorService.getDoctorById(1);
        assertThat(doctor.getProfile().getName()).isEqualTo("Vasya");

        /** Delete Doctor */
        this.doctorService.removeDoctor(1);
        assertThat(this.doctorService.getDoctorById(1)).isNull();
    }

    @Test(expected = DublicateEmailException.class)
    public void shouldThrowDublicateEmailException() throws DublicateEmailException{
        this.doctorService.addDoctor(this.doctor);
        this.doctorService.addDoctor(this.doctor);
    }
}
