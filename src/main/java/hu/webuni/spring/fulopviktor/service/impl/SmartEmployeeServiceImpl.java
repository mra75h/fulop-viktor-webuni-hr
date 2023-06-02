package hu.webuni.spring.fulopviktor.service.impl;

import hu.webuni.spring.fulopviktor.configurations.properties.HrEmployeeConfigProperties;
import hu.webuni.spring.fulopviktor.model.Employee;
import hu.webuni.spring.fulopviktor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class SmartEmployeeServiceImpl implements EmployeeService {

    @Autowired
    private HrEmployeeConfigProperties hrEmployeeConfigProperties;

    @Override
    public int getPayRaisePercent(Employee employee) {

        if (employee != null && employee.getSalary() != null && employee.getStartDate() != null) {
            LocalDateTime now = LocalDateTime.now();
            long howLongWorkTime = YEARS.between(employee.getStartDate(), now);

            Set<Double> percents = hrEmployeeConfigProperties.getSmart().getPercentWithLimit().keySet();
            for (Double percent : percents ) {
                if (howLongWorkTime >= percent) {
                    double asd = (employee.getSalary() * hrEmployeeConfigProperties.getSmart().getPercentWithLimit().get(percent));
                    return (int) asd;
                }
            }

            Optional<Double> minPercent = percents.stream().min(Double::compare);
            if (!minPercent.isEmpty()) {
                if (howLongWorkTime <= minPercent.get()) {
                    return (int) (employee.getSalary() * hrEmployeeConfigProperties.getSmart().getPercentWithLimit().get(minPercent.get()));
                }
            }
        }

        return -1;
    }
}
