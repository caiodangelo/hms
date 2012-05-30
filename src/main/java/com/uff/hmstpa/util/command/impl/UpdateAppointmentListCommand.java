package com.uff.hmstpa.util.command.impl;

import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.util.command.Command;
import com.uff.hmstpa.vision.ScheduleSystemView;
import java.util.List;

public class UpdateAppointmentListCommand implements Command {

    ScheduleSystemView receiver;
    List<Appointment> appointments;
    
    
   //Teste
    
    public UpdateAppointmentListCommand(ScheduleSystemView receiver, List<Appointment> appointments) {
        this.receiver = receiver;
        this.appointments = appointments;
    }    
    
    public void execute() {
        receiver.updateAppointmentsList(this.appointments);
    }
    
}
