package com.uff.hmstpa.model.domain.valueobject;

public class Patient {
    
    private String cpf;
    private String name;

    public Patient(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Patient() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
