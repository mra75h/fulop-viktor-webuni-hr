package hu.webuni.spring.fulopviktor.configurations;

import hu.webuni.spring.fulopviktor.service.EmployeeService;
import hu.webuni.spring.fulopviktor.service.impl.SmartEmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeService() {
        return new SmartEmployeeServiceImpl();
    }
}
