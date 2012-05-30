package com.uff.hmstpa.util.observer;

import com.uff.hmstpa.model.ScheduleSystemModel;
import com.uff.hmstpa.util.command.Command;

/*
 * OBSERVER
 */

public interface Observer {
    public void update(ScheduleSystemModel subject, Command cmd);
}
