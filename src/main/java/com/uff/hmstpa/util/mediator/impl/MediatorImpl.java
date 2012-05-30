package com.uff.hmstpa.util.mediator.impl;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.model.ScheduleSystemModel;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.model.domain.valueobject.Patient;
import com.uff.hmstpa.model.service.AppointmentService;
import com.uff.hmstpa.model.service.DoctorService;
import com.uff.hmstpa.model.service.PatientService;
import com.uff.hmstpa.util.command.impl.UpdateAppointmentListCommand;
import com.uff.hmstpa.util.date.DateParse;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import com.uff.hmstpa.util.mediator.Mediator;
import com.uff.hmstpa.util.memento.AppointmentHistory;
import com.uff.hmstpa.util.memento.AppointmentMemento;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

public class MediatorImpl implements Mediator {

    private ScheduleSystemController controller;
    private ScheduleSystemModel model;
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentService appointmentService;
    private AppointmentHistory caretaker = new AppointmentHistory();

    public void registerController(ScheduleSystemController controller) {
        //TODO verificar se está certa essa referência
        this.controller = controller;
    }

    public void registerModel(ScheduleSystemModel model) {
        this.model = model;
    }

    public void registerService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public void registerService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void registerService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public void createAppointment(Map<String, String> params) {
        String crm = params.get("crm");
        String cpf = params.get("cpf");
        String name = params.get("name");
        String time = params.get("time");

        boolean deletePatientOnError = false;

        Doctor doctor = doctorService.retrieveDoctor(crm);
        Patient patient = patientService.retrievePatient(cpf);
        if (patient == null) {
            deletePatientOnError = true;
            patient = patientService.createPatient(cpf, name);
        }
        try {
            DateTime dateTime = new DateTime(DateParse.parseStringDate(time).getTime());
            Appointment appointment = appointmentService.createAppointment(doctor, patient, dateTime);
            caretaker.addMemento(new AppointmentMemento(appointment));
        } catch (BusinessRuleException ex) {
            Logger.getLogger(MediatorImpl.class.getName()).log(Level.SEVERE, null, ex);
            if (deletePatientOnError) {
                patientService.deletePatient(cpf);
            }
        } catch (Exception e) {
            if (deletePatientOnError) {
                patientService.deletePatient(cpf);
            }
        }

        model.notifyObservers(new UpdateAppointmentListCommand(controller.getView(),
                appointmentService.retrieveAppointmentList(model.getSelectedDoctor())));
    }

    public void loadDoctors() {
        List<Doctor> doctors = doctorService.retrieveDoctors();
        for (Doctor doctor : doctors) {
            model.addDoctor(doctor);
        }
        model.notifyObservers(new UpdateAppointmentListCommand(controller.getView(),
                appointmentService.retrieveAppointmentList(model.getSelectedDoctor())));
    }

    public List<Doctor> retrieveDoctors() {
        return model.retrieveDoctors();
    }

    public void addDoctorToModel(Doctor doctor) {
        model.addDoctor(doctor);
    }

    public Doctor getSelectedDoctor() {
        return model.getSelectedDoctor();
    }

    public void setSelectedDoctor(String doctorName) {
        if (doctorName == null) {
            model.setSelectedDoctor(null);
        } else {
            List<Doctor> doctors = model.retrieveDoctors();

            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getName().equalsIgnoreCase(doctorName)) {
                    model.setSelectedDoctor(doctors.get(i));
                }
            }
        }

        model.notifyObservers(new UpdateAppointmentListCommand(controller.getView(),
                appointmentService.retrieveAppointmentList(model.getSelectedDoctor())));
    }

    public void undoAppointment() {
        AppointmentMemento memento = caretaker.restoreMemento();
        appointmentService.removeAppointment(
                memento.getDoctor().getCRM(),
                memento.getPatient().getCpf(),
                memento.getTime());
    }

    public void sendErrorToModel(BusinessRuleException e) {
        //TODO pensar se esse tratamento será feito aqui mesmo
        //controller.handleError(e);
    }
}
