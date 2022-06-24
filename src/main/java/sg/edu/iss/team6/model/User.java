package sg.edu.iss.team6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Table(name = "User")
@NoArgsConstructor
//@Entity
public class User {
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;

    public User(@NotEmpty String userId, @NotEmpty String password) {
        this.userId = userId;
        this.password = password;
    }
}
