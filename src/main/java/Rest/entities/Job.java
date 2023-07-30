package Rest.entities;

import lombok.Data;

@Data
public class Job {
    public Integer id;
    public String title;
    public String description;
    public Integer price;
    public String user;
    public Integer noOfComments;
}
