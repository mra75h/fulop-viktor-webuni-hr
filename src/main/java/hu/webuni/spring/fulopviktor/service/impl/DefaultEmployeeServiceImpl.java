package hu.webuni.spring.fulopviktor.service.impl;

import hu.webuni.spring.fulopviktor.configurations.properties.HrEmployeeConfigProperties;
import hu.webuni.spring.fulopviktor.model.Employee;
import hu.webuni.spring.fulopviktor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeServiceImpl implements EmployeeService {

    @Autowired
    private HrEmployeeConfigProperties  hrEmployeeConfigProperties;

    @Override
    public int getPayRaisePercent(Employee employee) {
        int resultSalary = -1;

        if (employee != null && employee.getSalary() != null) {
            resultSalary = (int) (employee.getSalary() * hrEmployeeConfigProperties.getDef().getFix().getPercent());
        }

        return resultSalary;
    }
}
