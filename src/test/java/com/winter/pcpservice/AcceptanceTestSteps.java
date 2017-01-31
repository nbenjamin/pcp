package com.winter.pcpservice;

import com.winter.pcpservice.app.Application;
import com.winter.pcpservice.domain.Doctor;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import javax.sql.DataSource;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@Ignore
public class AcceptanceTestSteps {

  @Value("${local.server.port}")
  int port;

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  private ResponseEntity<Doctor> getDoctorByIdResponse;

  @Given("^a doctor with ID (\\d+) exist$")
  public void a_doctor_with_ID_exist(int id) throws Throwable {

  }

  @When("^the API is called for doctor ID \"([^\"]*)\"$")
  public void the_API_is_called_for_doctor_ID(String doctorId) throws Throwable {

    String url = UriComponentsBuilder.fromUri(new URI("http://localhost:"+ port)).pathSegment
            ("pcp/doctors")
        .pathSegment(doctorId).build().toUriString();

    getDoctorByIdResponse = new RestTemplate().getForEntity(url, Doctor.class);
  }

  @Then("^the API returns doctor firstName \"([^\"]*)\"$")
  public void the_API_returns_doctor_firstName(String firstName) throws Throwable {
    assertThat(getDoctorByIdResponse.getBody().getFirstName(), is(firstName));
  }

}
