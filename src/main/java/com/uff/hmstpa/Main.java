package com.uff.hmstpa;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.controller.impl.ScheduleSystemControllerImpl;
import com.uff.hmstpa.model.impl.ScheduleSystemModelImpl;
import com.uff.hmstpa.model.service.impl.AppointmentServiceImpl;
import com.uff.hmstpa.model.service.impl.DoctorServiceImpl;
import com.uff.hmstpa.model.service.impl.PatientServiceImpl;
import com.uff.hmstpa.util.mediator.Mediator;
import com.uff.hmstpa.util.mediator.impl.MediatorImpl;

public class Main {
    
    //Teste alteração remota

    public static void main(String[] args) {
        Mediator mediator = new MediatorImpl();

        ScheduleSystemModelImpl model = new ScheduleSystemModelImpl();
        ScheduleSystemController controller = new ScheduleSystemControllerImpl(model, mediator);
        
        mediator.registerController(controller);
        mediator.registerModel(model);
        mediator.registerService(new DoctorServiceImpl(mediator));
        mediator.registerService(new PatientServiceImpl(mediator));
        mediator.registerService(new AppointmentServiceImpl(mediator));
        
        controller.init();
    }
}
