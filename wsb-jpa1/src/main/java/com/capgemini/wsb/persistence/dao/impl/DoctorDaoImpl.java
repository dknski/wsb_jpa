package com.capgemini.wsb.persistence.dao.impl;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DoctorEntity> findDoctorsBySpecialization(String specialization) {
        TypedQuery<DoctorEntity> query = entityManager.createQuery(
                "SELECT d FROM DoctorEntity d WHERE d.specialization = :specialization", DoctorEntity.class);
        query.setParameter("specialization", specialization);
        return query.getResultList();
    }
}