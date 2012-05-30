package com.uff.hmstpa.model.persistence;

import com.uff.hmstpa.model.domain.valueobject.Appointment;
import java.util.List;
import org.joda.time.DateTime;

public interface AppointmentDAO {
    
    void persist(String crm, String cpf, DateTime time);
    Appointment retrieve(String crm, String cpf, DateTime time);
    List<Appointment> loadAppointments(String doctorCRM);
    List<Appointment> loadAllAppointments();
    void delete(String crm, String cpf, DateTime time);
    
}
