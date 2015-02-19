package com.clinic;

import com.clinic.exceptions.DublicateEmailException;
import com.clinic.model.Doctor;
import com.clinic.model.Profile;
import com.clinic.service.DoctorService;
import com.clinic.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/config/testContextConfiguration.xml",
                                    "file:src/main/webapp/WEB-INF/spring-security.xml" })
public class DoctorServiceTest {
    @Autowired(required = true)
    DoctorService doctorService;

    @Autowired(required = true)
    UserService userService;

    @Test
    @Transactional
    public void shouldInsertDoctor() throws DublicateEmailException {

        Profile profile = new Profile();
        profile.setEmail("Seal26ster@gmail.com");
        profile.setName("Eugene");
        profile.setSurname("Ovsiy");
        profile.setPhone("45645623");

        Doctor doctor = new Doctor();
        doctor.setProfile(profile);

        this.doctorService.addDoctor(doctor);

        assertThat(doctor.getId()).isNotEqualTo(0);
        assertThat(doctor.getId()).isEqualTo(1);
        assertThat(doctor.getProfile().getCreated_at()).isNotNull();

        assertThat(doctor.getProfile().getName()).isEqualTo("Eugene");
    }

}
