package com.uff.hmstpa.model;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.util.command.Command;
import com.uff.hmstpa.util.observer.Observer;
import java.util.List;

/**
 * [MODELO]
 */
public interface ScheduleSystemModel {

    public void addDoctor(Doctor doctor);

    public List<Doctor> retrieveDoctors();

    void setSelectedDoctor(Doctor doctor);

    Doctor getSelectedDoctor();

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Command cmd);
}
