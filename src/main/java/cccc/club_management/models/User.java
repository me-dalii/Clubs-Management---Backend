package cccc.club_management.models;

import cccc.club_management.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String phone;
    private Date dob;
    private Gender gender;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="grade_id", referencedColumnName = "id")
    private Grade grade;


}
