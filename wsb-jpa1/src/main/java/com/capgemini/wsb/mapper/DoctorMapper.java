package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    @Autowired
    private VisitMapper visitMapper;

    public DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }

        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());

        if (doctorEntity.getVisits() != null) {
            List<VisitTO> visits = doctorEntity.getVisits().stream()
                    .map(visitMapper::toVisitTO)
                    .collect(Collectors.toList());
            doctorTO.setVisits(visits);
        } else {
            doctorTO.setVisits(Collections.emptyList());
        }

        return doctorTO;
    }
}
