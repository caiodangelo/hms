package com.uff.hmstpa.model.service;

import com.uff.hmstpa.model.domain.entity.Doctor;
import java.util.List;


public interface DoctorService {

    List<Doctor> retrieveDoctors();

    Doctor retrieveDoctor(String crm);
	
}
