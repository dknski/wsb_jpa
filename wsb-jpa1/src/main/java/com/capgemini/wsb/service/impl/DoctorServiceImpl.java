package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.repository.DoctorRepository;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorTO findById(Long id) {
        return DoctorMapper.mapToTO(doctorRepository.findById(id).orElseThrow());
    }
}
