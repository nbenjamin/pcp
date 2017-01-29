package com.winter.pcpservice.domain;

import java.util.List;

public interface DoctorRepository {

  Doctor getDoctor(Integer id);

  List<Doctor> getDoctors(String location);

  Doctor createDoctor(Doctor doctor);

}
