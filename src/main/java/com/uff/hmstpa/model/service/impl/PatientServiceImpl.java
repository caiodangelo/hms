package com.uff.hmstpa.model.service.impl;

import com.uff.hmstpa.model.domain.valueobject.Patient;
import com.uff.hmstpa.model.persistence.PatientDAO;
import com.uff.hmstpa.model.persistence.impl.PatientDAOImpl;
import com.uff.hmstpa.model.service.PatientService;
import com.uff.hmstpa.util.mediator.Mediator;

public class PatientServiceImpl implements PatientService {

    private Mediator mediator;
    private PatientDAO patientDAO = PatientDAOImpl.getInstance();

    public PatientServiceImpl(Mediator mediator) {
        mediator.registerService(this);
        this.mediator = mediator;
    }

    public Patient retrievePatient(String cpf) {
        return patientDAO.retrieve(cpf);
    }

    public Patient createPatient(String cpf, String name) {
        Patient p = patientDAO.retrieve(cpf);
        if (p == null) {
            patientDAO.persist(cpf, name);
            p = patientDAO.retrieve(cpf);
        }

        return p;
    }

    public void deletePatient(String cpf) {
        patientDAO.delete(cpf);
    }
   
}
