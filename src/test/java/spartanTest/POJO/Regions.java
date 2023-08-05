package spartanTest.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Regions {

    @JsonProperty("region_id")
    private String region_id;
    @JsonProperty("region_name")
    private String region_name;
    private List<Link> links;
}
