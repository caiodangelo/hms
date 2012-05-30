package com.uff.hmstpa.model.domain.valueobject;

import com.uff.hmstpa.model.domain.entity.Doctor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Appointment {
    
    private Doctor doctor;
    private Patient patient;
    private DateTime time;
    
    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return time.toString(DateTimeFormat.forPattern("yyyy/MM/dd hh:mm")) + " - " + patient.getName();
    }
    
    
}
