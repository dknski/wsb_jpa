package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VisitMapper {

    public VisitTO toVisitTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctorId(visitEntity.getDoctor().getId());
        visitTO.setPatientId(visitEntity.getPatient().getId());

        return visitTO;
    }

    public List<VisitTO> toVisitTOList(List<VisitEntity> visitEntities) {
        if (visitEntities == null) {
            return null;
        }

        return visitEntities.stream()
                .map(this::toVisitTO)
                .collect(Collectors.toList());
    }
}
