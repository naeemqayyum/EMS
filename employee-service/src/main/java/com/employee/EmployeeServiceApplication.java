package com.employee;

import com.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class EmployeeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);

        // ✅ Correctly placed inside the main method
        Person person = new Person("naeem", 12);
        System.out.println(person.name());
        System.out.println(person.id());
    }
}
