package hu.webuni.spring.fulopviktor.model;

import hu.webuni.spring.fulopviktor.enums.Disposition;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {

    private Long name;

    private Disposition disposition;

    private Integer salary;

    private LocalDateTime startDate;

}
