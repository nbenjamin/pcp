package com.winter.pcpservice.adapter.datastore;

import com.winter.pcpservice.domain.Doctor;
import com.winter.pcpservice.domain.DoctorRepository;
import com.winter.pcpservice.exception.PCPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcDoctorRepository implements DoctorRepository {

  private static final String GET_DOCTOR_BY_ID =
      "select id, firstName, lastName, location from doctor where id = ?";

  private static final String GET_DOCTORS_BY_LOCATION =
          "select id, firstName, lastName, location from doctor where location = ?";

  private static final String INSERT_DOCTOR =
          "insert into doctor (firstName, lastName, location) " +
                  "values (?,?,?)";

  @Autowired
  @Qualifier("jdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Override
  public Doctor getDoctor(Integer id) {
    try {
      return jdbcTemplate.queryForObject(GET_DOCTOR_BY_ID, new DoctorRowMapper(), id);
    } catch (DataAccessException e) {
      throw new PCPException("JdbcDoctorRepositoryGetDoctorByIdAccessException - id " + id, e);
    }
  }

  @Override
  public List<Doctor> getDoctors(String location) {
    try {
      return jdbcTemplate.query(GET_DOCTORS_BY_LOCATION, new DoctorRowMapper(), location);
    } catch (DataAccessException e) {
      throw new PCPException("JdbcDoctorRepositoryGetDoctorByLocationAccessException - location " +
              location, e);
    }
  }

  @Override
  public Doctor createDoctor(Doctor doctor) {
    jdbcTemplate.update(INSERT_DOCTOR, ps -> {
      ps.setString(1, doctor.getFirstName());
      ps.setString(2, doctor.getLastName());
      ps.setString(3, doctor.getLocation());
    });
    return doctor;
  }

  private static class DoctorRowMapper implements RowMapper<Doctor> {

    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
      Doctor doctor = new Doctor();
      doctor.setId(rs.getInt(1));
      doctor.setFirstName(rs.getString(2));
      doctor.setLastName(rs.getString(3));
      doctor.setLocation(rs.getString(4));
      return doctor;
    }
  }
}
