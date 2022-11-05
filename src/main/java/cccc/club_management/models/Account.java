package cccc.club_management.models;

import cccc.club_management.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Account extends AbstractEntity{

    private String username;
    private String password;
    private Role role;
    private Boolean status;

    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private User user;

}
