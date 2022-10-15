package cccc.club_management.models;

import cccc.club_management.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Account extends AbstractEntity{

    private String username;
    private String password;
    private Role role;

}
