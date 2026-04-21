package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account implements Serializable {
    private String login;
    @ToString.Exclude
    private String password;
    private Role role;
}
