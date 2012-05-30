package com.uff.hmstpa.model.service;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.model.domain.valueobject.Patient;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import com.uff.hmstpa.util.memento.AppointmentMemento;
import java.util.List;
import org.joda.time.DateTime;

/**
 * O Service de Appointment é o responsável por interagir com o sistema nas operações
 * que tenham como participante principal um Appointment.
 * É o responsável também por definir as regras de negócio no que diz respeito
 * aos Appointments.
 * @author Lucas
 *
 */
public interface AppointmentService {

	List<Appointment> retrieveAppointmentList(Doctor doctor);

	Appointment retrieveAppointment(Doctor doctor, Patient patient, DateTime time);
	
	Appointment createAppointment(Doctor doctor, Patient patient, DateTime time) throws BusinessRuleException;

	void removeAppointment(String crm, String cpf, DateTime time);
}
