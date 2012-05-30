package com.uff.hmstpa.model.persistence;

import com.uff.hmstpa.model.domain.valueobject.Patient;
import java.util.List;

public interface PatientDAO {
    
    void persist(String cpf, String name);
    
    Patient retrieve(String cpf);
    
    List<Patient> retrieveAllPatients();
    
    /**
     * Recupera as instâncias de Paciente que possuam consulta com determinado Doutor
     * @param doctorCRM O crm do Doutor em questão
     * @return Uma lista de Pacientes
     */
    List<Patient> loadPatients(String doctorCRM);
    
    void delete(String cpf);
    
}
