package com.uff.hmstpa.util.memento;

import org.joda.time.DateTime;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.model.domain.valueobject.Patient;

public class AppointmentMemento {
	
	private Doctor doctor;
	private Patient patient;
	private DateTime time;
	
	public AppointmentMemento(Appointment appointment) {
		this.doctor = appointment.getDoctor();
		this.patient = appointment.getPatient();
		this.time = appointment.getTime();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public DateTime getTime() {
		return time;
	}

}
