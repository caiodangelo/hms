package com.uff.hmstpa.model.persistence.impl;

import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.persistence.AbstractModelDAO;
import com.uff.hmstpa.model.persistence.DoctorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class DoctorDAOImpl extends AbstractModelDAO implements DoctorDAO {

    private static DoctorDAOImpl SOLE_INSTANCE;

    private DoctorDAOImpl() {
        super();
    }

    public static DoctorDAO getInstance() {
        if (SOLE_INSTANCE == null) {
            SOLE_INSTANCE = new DoctorDAOImpl();
        }
        return SOLE_INSTANCE;
    }

    public void persist(String crm, String name, String specialty) {
        jdbcTemplate.update("INSERT INTO doctor(crm, name, specialty) VALUES(?, ?, ?)", crm, name, specialty);

    }

    public void delete(String crm) {
        jdbcTemplate.update("DELETE FROM doctor WHERE crm = ?", crm);
    }

    /**
     * Recupera informações de todos os doutores no sistema
     */
    public List<Doctor> load() {
        return jdbcTemplate.query("SELECT * FROM doctor", new DoctorMapper());
    }

    public Doctor retrieve(String crm) {
        return jdbcTemplate.queryForObject("SELECT * FROM doctor WHERE crm = ?", new Object[]{crm}, new DoctorMapper());
    }

    private static final class DoctorMapper implements RowMapper<Doctor> {

        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Doctor();
            doctor.setCRM(rs.getString("crm"));
            doctor.setName(rs.getString("name"));
            doctor.setSpecialty(rs.getString("specialty"));
            return doctor;
        }
    }
}
