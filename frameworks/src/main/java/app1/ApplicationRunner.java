package app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:9000/
@SpringBootApplication
public class ApplicationRunner {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationRunner.class, args);
  }
}
