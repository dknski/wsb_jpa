package com.capgemini.wsb.repository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName")
    List<PatientEntity> findPatientsByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM PatientEntity p WHERE (SELECT COUNT(v) FROM VisitEntity v WHERE v.patient.id = p.id) > :visitCount")
    List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("visitCount") Long visitCount);

    @Query("SELECT p FROM PatientEntity p WHERE p.age > :age")
    List<PatientEntity> findPatientsByAgeGreaterThan(@Param("age") int age);
}
