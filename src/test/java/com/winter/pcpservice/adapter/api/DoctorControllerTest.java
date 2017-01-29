package com.winter.pcpservice.adapter.api;

import com.winter.pcpservice.domain.Doctor;
import com.winter.pcpservice.domain.DoctorRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

  @Mock
  private DoctorRepository mockDoctorRepository;

  @InjectMocks
  private DoctorController subject;

  @Before
  public void before() {
    // Setup code to be run before every test
  }

  @Test
  public void new_defaultConstructor_notNull() {
    assertThat(subject, notNullValue());
  }

  @Test
  public void getDoctor_validId_callsRepoWithSuppliedIdAndReturnsDoctor() {

    Doctor mockDoctor = mock(Doctor.class);
    when(mockDoctorRepository.getDoctor(1)).thenReturn(mockDoctor);

    Doctor actual = subject.getDoctor(1);

    assertThat(actual, is(equalTo(mockDoctor)));

    verify(mockDoctorRepository).getDoctor(1);
  }

}
