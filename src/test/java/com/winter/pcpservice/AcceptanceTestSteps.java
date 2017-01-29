package com.winter.pcpservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.winter.pcpservice.app.Application;
import com.winter.pcpservice.domain.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@Ignore
public class AcceptanceTestSteps {

  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  private ResponseEntity<Doctor> getDoctorByIdResponse;

  @Given("^a doctor with ID (\\d+) exist$")
  public void a_doctor_with_ID_exist(int id) throws Throwable {

  }

  @When("^the API is called for doctor ID \"([^\"]*)\"$")
  public void the_API_is_called_for_doctor_ID(String doctorId) throws Throwable {

    String url = UriComponentsBuilder.fromUri(new URI("localhost:8080/")).pathSegment("pcp/doctors")
        .pathSegment(doctorId).build().toUriString();

    getDoctorByIdResponse = new RestTemplate().getForEntity(url, Doctor.class);
  }

  @Then("^the API returns doctor firstName \"([^\"]*)\"$")
  public void the_API_returns_doctor_firstName(String firstName) throws Throwable {
    assertThat(getDoctorByIdResponse.getBody().getFirstName(), is(firstName));
  }

}
