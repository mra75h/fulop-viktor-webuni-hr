package hu.webuni.spring.fulopviktor.configurations.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "hr.employee")
@Component
@Data
public class HrEmployeeConfigProperties {

    private Def def = new Def();

    private Smart smart = new Smart();

    @Data
    public static class Def {
        private Fix fix;
    }

    @Data
    public static class Fix {
        private int percent;
    }

    @Data
    public static class Smart {
        private Map<Double, Double> percentWithLimit;
    }

}
