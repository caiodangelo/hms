package com.uff.hmstpa.util.mediator;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.model.ScheduleSystemModel;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.service.AppointmentService;
import com.uff.hmstpa.model.service.DoctorService;
import com.uff.hmstpa.model.service.PatientService;
import com.uff.hmstpa.util.command.Command;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import java.util.List;
import java.util.Map;

public interface Mediator {
    
    void registerController(ScheduleSystemController controller);
    
    void registerModel(ScheduleSystemModel model);
    
    void registerService(DoctorService doctorService);
    
    void registerService(PatientService patientService);
    
    void registerService(AppointmentService appointmentService);
    
    void createAppointment(Map<String, String> params);
    
    void loadDoctors();
    
    List<Doctor> retrieveDoctors();
    
    public void addDoctorToModel(Doctor doctor);
    
    void setSelectedDoctor(String doctorName);
    
    Doctor getSelectedDoctor();
    
    public void undoAppointment();
    
    void sendErrorToModel(BusinessRuleException e);
    
}
