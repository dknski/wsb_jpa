package com.capgemini.wsb.persistence.dao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import java.util.List;

public interface DoctorDao {
    List<DoctorEntity> findDoctorsBySpecialization(String specialization);
}