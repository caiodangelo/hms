package com.uff.hmstpa.vision;

import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import java.util.List;
import java.util.Map;

/**
 * [VISÃO] O SchedulerSystemView é um OBSERVADOR do SchedulerSystemModel.
 *
 * @author Lucas
 */
public interface ScheduleSystemView {

    void updateAppointmentsList(List<Appointment> appointments);

    void showError(BusinessRuleException e);

    public Map<String, String> getCreateAppointmentParams();
}
