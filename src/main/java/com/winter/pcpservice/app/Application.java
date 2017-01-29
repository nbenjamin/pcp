package com.winter.pcpservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.winter.pcpservice")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
