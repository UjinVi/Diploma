package Rest.entities;

import lombok.Data;

@Data
public class SignInUp {
    private String username ;
    private String password;
    private String confirmPassword;

}