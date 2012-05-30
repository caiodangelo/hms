package com.uff.hmstpa.model.domain.entity;

public class Doctor {
    private String specialty;
    private String CRM;
    private String name;

    public Doctor() {
    }

    public Doctor(String specialty, String CRM, String name) {
        this.specialty = specialty;
        this.CRM = CRM;
        this.name = name;
    }   

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
