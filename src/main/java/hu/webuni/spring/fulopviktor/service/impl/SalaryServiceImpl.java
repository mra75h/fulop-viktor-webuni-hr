package hu.webuni.spring.fulopviktor.service.impl;

import hu.webuni.spring.fulopviktor.model.Employee;
import hu.webuni.spring.fulopviktor.service.EmployeeService;
import hu.webuni.spring.fulopviktor.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private EmployeeService employeeService;

    public int getSalary(Employee employee) {
       return employeeService.getPayRaisePercent(employee);
    }
}
