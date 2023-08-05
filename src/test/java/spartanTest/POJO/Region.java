package spartanTest.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Region {

    private List<Regions> items;
    private boolean hasMore;
    private int limit;
    private int offset;
    private int count;
    private List<Link> links;

}
