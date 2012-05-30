package com.uff.hmstpa.model.persistence;

import com.uff.hmstpa.model.domain.entity.Doctor;
import java.util.List;

public interface DoctorDAO {
    
    void persist(String crm, String name, String specialty);
    Doctor retrieve(String crm);
    List<Doctor> load();
    void delete(String crm);
}
