package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
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
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Transactional
    @Test
    public void deletePatientsWithoutRemovingDoctors() {
        // Given
        Long patientId = 1L;

        // When
        patientService.deletePatient(patientId);

        // Then
        assertThat(patientService.findAll().size()).isEqualTo(1);

        final DoctorTO doctorTO = doctorService.findById(1L);
        assertThat(doctorTO.getVisits().size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void checkAfterAddingNewPatient() {
        // Given
        Long patientId = 1L;

        // When
        final Integer age = patientService.getPatientById(patientId).getAge();

        // Then
        assertThat(age).isEqualTo(42);
    }

    @Transactional
    @Test
    public void findAllVisitsByPatientId() {
        // Given
        Long patientId = 1L;

        // When
        final List<VisitTO> listOfVisits = patientService.findVisitsByPatientId(patientId);

        // Then
        assertThat(listOfVisits.size()).isEqualTo(2);
    }

}
