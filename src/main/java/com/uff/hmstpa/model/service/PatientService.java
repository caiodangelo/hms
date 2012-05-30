package com.uff.hmstpa.model.service;

import com.uff.hmstpa.model.domain.valueobject.Patient;

public interface PatientService {
	
	/**
	 * Busca um Paciente com o CPF informado.
	 * @param cpf o número de cpf utilizado na busca
	 * @return Uma instãncia de Paciente com o CPF informado, nulo, caso contrário.
	 */
	Patient retrievePatient(String cpf);
	
	/**
	 * Cria um Paciente no sistema com o cpf e o nome passados como parâmetro. Caso já exista
	 * um Paciente com o mesmo cpf e nome, retorna uma instância deste Paciente.
	 * @param cpf o número de cpf do Paciente
	 * @param name o nome do Paciente
	 * @return Uma instância de Paciente com o cpf e nome passados como parâmetro
	 */
	Patient createPatient(String cpf, String name);
        
        void deletePatient(String cpf);

}
