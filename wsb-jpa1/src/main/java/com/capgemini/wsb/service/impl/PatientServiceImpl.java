package com.capgemini.wsb.service.impl;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private VisitMapper visitMapper;

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientTO> findAll() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientTO getPatientById(Long id) {
        return patientMapper.toPatientTO(patientRepository.findById(id).orElseThrow());
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        return visitRepository.findVisitsByPatientId(patientId).stream()
                .map(visitMapper::toVisitTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientTO> findPatientsByLastName(String lastName) {
        return patientRepository.findPatientsByLastName(lastName).stream()
                .map(patientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientTO> findPatientsWithMoreThanXVisits(int visitCount) {
        return patientRepository.findPatientsWithMoreThanXVisits((long)visitCount).stream()
                .map(patientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientTO> findPatientsByAgeGreaterThan(int age) {
        return patientRepository.findPatientsByAgeGreaterThan(age).stream()
                .map(patientMapper::toPatientTO)
                .collect(Collectors.toList());
    }
}
