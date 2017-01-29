package com.winter.pcpservice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test case for <code>{@link Doctor}</code>.
 */
public class DoctorTest {

  /**
   * Test for <code>{@link Doctor#toString()}</code>.
   */
  @Test
  public final void toString_populatedInstance_validJson() {
    Doctor subject = new Doctor();
    subject.setId(1);
    subject.setFirstName("Ryan");
    subject.setLastName("Adam");
    subject.setLocation("Bangalore");
    String expected = ToStringBuilder.reflectionToString(subject, ToStringStyle.JSON_STYLE);
    assertThat(subject.toString(), is(expected));
  }

  /**
   * Test for <code>{@link Doctor#equals(Object)}</code>.
   */
  @Test
  public final void equals_sameInstanceVars_isEqual() {
    Doctor subject = new Doctor();
    subject.setId(1);
    subject.setFirstName("Ryan");
    subject.setLastName("Adam");
    subject.setLocation("Bangalore");

    Doctor expected = new Doctor();
    expected.setId(1);
    expected.setFirstName("Ryan");
    expected.setLastName("Adam");
    expected.setLocation("Bangalore");

    assertThat(subject.equals(expected), is(true));
  }

  /**
   * Test for <code>{@link Doctor#hashCode()}</code>.
   */
  @Test
  public final void hashCode_sameInstanceVars_hashCodeIsEqual() {
    Doctor subject = new Doctor();
    subject.setId(1);
    subject.setFirstName("Ryan");
    subject.setLastName("Adam");
    subject.setLocation("Bangalore");

    Doctor expected = new Doctor();
    expected.setId(1);
    expected.setFirstName("Ryan");
    expected.setLastName("Adam");
    expected.setLocation("Bangalore");

    assertThat(subject.hashCode(), is(expected.hashCode()));
  }


  @Test
  public final void verifyContractForId() {
    Doctor subject = new Doctor();
    Integer expected = 1;
    subject.setId(expected);
    assertThat(subject.getId(), is(expected));
  }
}
