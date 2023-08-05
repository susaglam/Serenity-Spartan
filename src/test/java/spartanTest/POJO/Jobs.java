package spartanTest.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Jobs {

    private String job_id;
    private String job_title;
    private int min_salary;
    private int max_salary;
    private List<Link> links;
}
