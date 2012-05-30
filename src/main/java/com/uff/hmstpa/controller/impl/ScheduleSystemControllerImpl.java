package com.uff.hmstpa.controller.impl;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.impl.ScheduleSystemModelImpl;
import com.uff.hmstpa.util.mediator.Mediator;
import com.uff.hmstpa.vision.ScheduleSystemView;
import com.uff.hmstpa.vision.impl.ScheduleSystemUI;
import java.util.List;

public class ScheduleSystemControllerImpl implements ScheduleSystemController {

    private Mediator mediator;
    private ScheduleSystemView view;

    public ScheduleSystemControllerImpl(ScheduleSystemModelImpl model, Mediator mediator) {
        this.view = new ScheduleSystemUI(model, this);
        this.mediator = mediator;
    }

    public void init() {
        mediator.loadDoctors();
    }

    public void addDoctor(Doctor doctor) {
        mediator.addDoctorToModel(doctor);
    }

    public List<Doctor> retrieveDoctors() {
        return mediator.retrieveDoctors();
    }

    public void setSelectedDoctor(String doctorName) {
        mediator.setSelectedDoctor(doctorName);
    }

    public Doctor getSelectedDoctor() {
        return mediator.getSelectedDoctor();
    }

    public void createAppointment() {
        mediator.createAppointment(view.getCreateAppointmentParams());
    }

    public ScheduleSystemView getView() {
        return this.view;
    }
}
