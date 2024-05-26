package com.capgemini.wsb.persistance.dao;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {


    @Autowired
    private PatientService patientService;


    @Transactional
    @Test
    public void testFindPatientsByLastName() {
        // Given
        String lastName = "Oko";

        // When
        List<PatientTO> patients = patientService.findPatientsByLastName(lastName);

        // Then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Transactional
    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        // Given
        int visitCount = 1;

        // When
        List<PatientTO> patients = patientService.findPatientsWithMoreThanXVisits(visitCount);

        // Then
        assertThat(patients).isNotEmpty();
    }

    @Transactional
    @Test
    public void testFindPatientsByAgeGreaterThan() {
        // Given
        int age = 25;

        // When
        List<PatientTO> patients = patientService.findPatientsByAgeGreaterThan(age);

        // Then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getAge()).isGreaterThan(age);
    }
}
