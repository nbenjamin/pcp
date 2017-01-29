package com.winter.pcpservice.adapter.api;

import com.winter.pcpservice.domain.Doctor;
import com.winter.pcpservice.domain.DoctorRepository;
import com.winter.pcpservice.exception.PCPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pcp/")
public class DoctorController {

  @Autowired
  private DoctorRepository doctorRepository;

  @RequestMapping(value = "/doctors/{id}")
  public Doctor getDoctor(@PathVariable("id") Integer id) {
    System.out.println(doctorRepository.getDoctor(id));
    return doctorRepository.getDoctor(id);
  }

  @RequestMapping(value = "/doctors/location/{location}")
  public List<Doctor> getDoctors(@PathVariable("location") String location) {
    return doctorRepository.getDoctors(location);
  }

  @PostMapping(value= "/doctors")
  public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
    return Optional.ofNullable(doctorRepository.createDoctor(doctor))
            .map(t -> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElseThrow(() -> new PCPException("Unable to create new doctor " + doctor));
  }
}
