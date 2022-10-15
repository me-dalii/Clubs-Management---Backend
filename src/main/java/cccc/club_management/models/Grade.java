package cccc.club_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Grade extends AbstractEntity{

    private String title;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;
}
