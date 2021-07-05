package tkstudy.starterproject.domain.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUserDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String password;
    private String passwordConfirmation;

    @NotNull
    @NotEmpty
    private String role;

    public String getUsername() {
        return this.username;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }

    public String getRole(){
        return this.role;
    }
}
