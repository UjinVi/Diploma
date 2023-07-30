package Rest.entities;

import lombok.Data;

@Data
public class Comment {
    public String id;
    public String message;
    public String username;
    public String commentDate;
}
