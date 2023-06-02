package hu.webuni.spring.fulopviktor;


import hu.webuni.spring.fulopviktor.model.Employee;
import hu.webuni.spring.fulopviktor.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

    @Autowired
    private SalaryService salaryService;

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setSalary(100);
        employee.setStartDate(LocalDateTime.of(2024, Month.MARCH, 15, 8, 0, 0));
        System.out.println(salaryService.getSalary(employee));
    }
}