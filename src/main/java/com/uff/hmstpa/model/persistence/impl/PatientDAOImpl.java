package com.uff.hmstpa.model.persistence.impl;

import com.uff.hmstpa.model.domain.valueobject.Patient;
import com.uff.hmstpa.model.persistence.AbstractModelDAO;
import com.uff.hmstpa.model.persistence.PatientDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
public class PatientDAOImpl extends AbstractModelDAO implements PatientDAO {

    private static PatientDAOImpl SOLE_INSTANCE;

    private PatientDAOImpl() {
        super();
    }

    public static PatientDAO getInstance() {
        if (SOLE_INSTANCE == null) {
            SOLE_INSTANCE = new PatientDAOImpl();
        }
        return SOLE_INSTANCE;
    }

    public void persist(String cpf, String name) {
        String sql = "INSERT INTO patient(cpf, name) values (?, ?)";
        Object[] params = new Object[]{cpf, name};
        jdbcTemplate.update(sql, params);
    }

    public List<Patient> loadPatients(String doctorCRM) {
        //TODO carrega lista de pacientes de um doutor
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(String cpf) {
        String sql = "DELETE FROM patient WHERE cpf = ?";
        Object[] params = new Object[]{cpf};
        jdbcTemplate.update(sql, params);
    }

    public Patient retrieve(String cpf) {
        String sql = "SELECT * FROM patient WHERE cpf = ?";
        Object[] params = new Object[]{cpf};
        try {
            return jdbcTemplate.queryForObject(sql, params, new PatientMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Patient> retrieveAllPatients() {
        String sql = "SELECT * FROM patient";
        try {
            return jdbcTemplate.query(sql, new PatientMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final class PatientMapper implements RowMapper<Patient> {

        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new Patient();
            patient.setCpf(rs.getString("cpf"));
            patient.setName(rs.getString("name"));
            return patient;
        }
    }
}
