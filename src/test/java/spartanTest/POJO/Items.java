package spartanTest.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Items {

    @JsonProperty("items")
    private List<Jobs> jobs;
    private boolean hasMore;
    private int limit;
    private int offset;
    private int count;
    private List<Link> links;
}
