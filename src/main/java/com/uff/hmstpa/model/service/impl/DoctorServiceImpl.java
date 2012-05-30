package com.uff.hmstpa.model.service.impl;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.persistence.DoctorDAO;
import com.uff.hmstpa.model.persistence.impl.DoctorDAOImpl;
import com.uff.hmstpa.model.service.DoctorService;
import com.uff.hmstpa.util.mediator.Mediator;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    
    private Mediator mediator;
    private DoctorDAO doctorDAO = DoctorDAOImpl.getInstance();

    public DoctorServiceImpl(Mediator mediator) {
        mediator.registerService(this);
        this.mediator = mediator;
    }

    public List<Doctor> retrieveDoctors() {
        return doctorDAO.load();
    }

    public Doctor retrieveDoctor(String crm) {
        return doctorDAO.retrieve(crm);
    }

}
