package com.capgemini.wsb.service.impl;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
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
    private PatientMapper patientMapper;

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientTO> findAll() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientTO getPatientById(Long id) {
        return patientMapper.toPatientTO(patientRepository.findById(id).orElseThrow());
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        return patient.getVisits()
                .stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
