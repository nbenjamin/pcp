package com.winter.pcpservice.adapter.datastore;

import com.winter.pcpservice.domain.Doctor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JdbcDoctorRepositoryTest.class,
    LiquibaseAutoConfiguration.LiquibaseConfiguration.class})
public class JdbcDoctorRepositoryTest {

  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Autowired
  private JdbcDoctorRepository subject;

  @Test
  public void new_defaultConstructor_notNull() {
    assertThat(subject, notNullValue());
  }

  @Test
  @Sql(scripts = "classpath:manageTestData.sql")
  public void getDoctor_validId_returnDoctor() {

    Doctor actual = subject.getDoctor(0);

    assertThat(actual.getId(), is(0));
    assertThat(actual.getFirstName(), is(equalTo("Ryan")));
    assertThat(actual.getLastName(), is(equalTo("Adam")));
    assertThat(actual.getLocation(), is(equalTo("Bangalore")));
  }

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
  }

  @Bean
  public JdbcDoctorRepository jdbcDoctorRepository() {
    return new JdbcDoctorRepository();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
}
