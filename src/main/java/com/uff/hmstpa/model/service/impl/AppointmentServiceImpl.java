package com.uff.hmstpa.model.service.impl;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.model.domain.valueobject.Patient;
import com.uff.hmstpa.model.persistence.AppointmentDAO;
import com.uff.hmstpa.model.persistence.impl.AppointmentDAOImpl;
import com.uff.hmstpa.model.service.AppointmentService;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import com.uff.hmstpa.util.mediator.Mediator;
import java.util.List;
import org.joda.time.DateTime;

public class AppointmentServiceImpl implements AppointmentService {

    private Mediator mediator;
    private AppointmentDAO appointmentDAO = AppointmentDAOImpl.getInstance();

    public AppointmentServiceImpl(Mediator mediator) {
        this.mediator = mediator;
    }

    public List<Appointment> retrieveAppointmentList(Doctor doctor) {
        if (doctor != null) {
            return appointmentDAO.loadAppointments(doctor.getCRM());
        } else {
            return appointmentDAO.loadAllAppointments();
        }
    }

    public Appointment retrieveAppointment(Doctor doctor, Patient patient, DateTime time) {
        return appointmentDAO.retrieve(doctor.getCRM(), patient.getCpf(), time);
    }

    public Appointment createAppointment(Doctor doctor, Patient patient, DateTime time) throws BusinessRuleException {
        Appointment appointment = null;

        //Verifica se a data não é menor do que a atual (regra de negócio)
        if (time.compareTo(DateTime.now()) <= 0) {
            throw new BusinessRuleException(this, "Data do agendamento deve ser posterior a data atual.");
        } else {
            appointment = retrieveAppointment(doctor, patient, time);
            if (appointment == null) {
                appointmentDAO.persist(doctor.getCRM(), patient.getCpf(), time);
            }
        }

        appointment = retrieveAppointment(doctor, patient, time);

        return appointment;
    }

    public void removeAppointment(String crm, String cpf, DateTime time) {
        appointmentDAO.delete(crm, cpf, time);

    }
}
