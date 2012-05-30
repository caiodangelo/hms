package com.uff.hmstpa.model.impl;

import com.uff.hmstpa.model.ScheduleSystemModel;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.util.command.Command;
import com.uff.hmstpa.util.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class ScheduleSystemModelImpl implements ScheduleSystemModel {

    private List<Doctor> doctors = new ArrayList();
    private Doctor selectedDoctor = null;
    private List<Observer> observers = new ArrayList();

    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public List<Doctor> retrieveDoctors() {
        return this.doctors;
    }

    public void setSelectedDoctor(Doctor selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    public void notifyObservers(Command cmd) {
        for (Observer observer : observers) {
            observer.update(this, cmd);
        }
    }

}
