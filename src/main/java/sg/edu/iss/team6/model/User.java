package sg.edu.iss.team6.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;

    public User(@NotEmpty String userId, @NotEmpty String password) {
        this.userId = userId;
        this.password = password;
    }
}
