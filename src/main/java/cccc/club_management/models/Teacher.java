package cccc.club_management.models;

import cccc.club_management.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Teacher extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String phone;
    private Date dob;
    private Gender gender;


}
