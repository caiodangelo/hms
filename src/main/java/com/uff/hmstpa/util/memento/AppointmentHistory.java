package com.uff.hmstpa.util.memento;

import java.util.Stack;

public class AppointmentHistory {
	
	private Stack<AppointmentMemento> appointmentHistory = new Stack<AppointmentMemento>();

	public void addMemento(AppointmentMemento a) {
		appointmentHistory.push(a);
	}
	
	public AppointmentMemento restoreMemento() {
		return appointmentHistory.pop();
	}
}
