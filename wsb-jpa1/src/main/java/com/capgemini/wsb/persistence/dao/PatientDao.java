package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao {
    List<PatientEntity> findPatientsWithMoreThanXVisits(int visitCount);
}
