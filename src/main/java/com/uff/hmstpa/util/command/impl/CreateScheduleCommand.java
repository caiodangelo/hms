package com.uff.hmstpa.util.command.impl;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.util.command.Command;

public class CreateScheduleCommand implements Command {
    
    ScheduleSystemController receiver;

    public CreateScheduleCommand(ScheduleSystemController receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.createAppointment();
    }
    
}
