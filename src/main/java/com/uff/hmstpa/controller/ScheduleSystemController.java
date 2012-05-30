package com.uff.hmstpa.controller;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.vision.ScheduleSystemView;
import java.util.List;

/**
 * [CONTROLADOR] O SchedulerSystemController é uma FACHADA para o
 * SchedulerSystemView dos diversos subsistemas (Controllers) por trás deste.
 *
 * @author Lucas
 */
public interface ScheduleSystemController {

    void init();

    ScheduleSystemView getView();

    /**
     * Adiciona um doutor ao modelo
     *
     * @param doctor O doutor que será adicionado ao modelo
     */
    void addDoctor(Doctor doctor);

    /**
     * Recupera todos os doutores armazenados no sistema.
     *
     * @return Uma lista de doutores.
     */
    List<Doctor> retrieveDoctors();

    /**
     * Define qual doutor será marcado como "selecionado" no sistema.
     *
     * @param doctorName O nome do doutor que será definido como doutor
     * selecionado.
     */
    void setSelectedDoctor(String doctorName);

    /**
     * Recupera a instância de doutor que está marcada como "selecionado".
     *
     * @return Uma instância de AbstractDoctor
     */
    Doctor getSelectedDoctor();

    void createAppointment();
}
