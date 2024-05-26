package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import java.util.List;

public interface PatientService {

    void deletePatient(Long id);

    List<PatientTO> findAll();

    PatientTO getPatientById(Long id);

    List<VisitTO> findVisitsByPatientId(Long patientId);

    List<PatientTO> findPatientsByLastName(String lastName);

    List<PatientTO> findPatientsWithMoreThanXVisits(int visitCount);

    List<PatientTO> findPatientsByAgeGreaterThan(int age);
}
