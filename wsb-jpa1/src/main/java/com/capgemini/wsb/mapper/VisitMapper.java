package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctor_id(visitEntity.getDoctor().getId());
        visitTO.setPatient_id(visitEntity.getPatient().getId());

        return visitTO;
    }

    public static List<VisitTO> toVisitTOList(final List<VisitEntity> visitEntities) {
        if (visitEntities == null) {
            return null;
        }
        return visitEntities.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
