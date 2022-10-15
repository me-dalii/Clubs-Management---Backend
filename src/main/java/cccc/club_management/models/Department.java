package cccc.club_management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Department extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy="department")
    @JsonIgnore
    private List<Grade> grades;
}
