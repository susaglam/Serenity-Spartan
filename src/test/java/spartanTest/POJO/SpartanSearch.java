package spartanTest.POJO;

import com.fasterxml.jackson.annotation.*;

import java.util.*;



@JsonIgnoreProperties(ignoreUnknown = true)
public class SpartanSearch {

    // response.path   and jsonpath

    @JsonProperty("content")
    private List<Spartan> content;

    @JsonProperty("totalElement")
    private int totalElement;

    public List<Spartan> getSpartanList() {
        return content;
    }

    public void setSpartanList(List<Spartan> spartanList) {
        this.content = spartanList;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    @Override
    public String toString() {
        return "SpartanSearch{" +
                "spartanList=" + content +
                ", totalElement=" + totalElement +
                '}';
    }
}
