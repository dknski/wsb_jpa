package com.capgemini.wsb.repository;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    @Query("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId")
    List<VisitEntity> findVisitsByPatientId(@Param("patientId") Long patientId);
}
