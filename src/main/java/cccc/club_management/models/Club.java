package cccc.club_management.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Club extends AbstractEntity{

    @Column(unique=true)
    private String name;
    private String description;
    @Column(unique=true)
    private String email;

    public Club(Long id, String name, String description, String email) {
        this.setId(id);
        this.name = name;
        this.description = description;
        this.email = email;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="logo_id", referencedColumnName = "id")
    private CustomFile logo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fsb_request_id", referencedColumnName = "id")
    private CustomFile FSBrequest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uc_request_id", referencedColumnName = "id")
    private CustomFile UCrequest;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="coordinator_id", referencedColumnName = "id")
    private Teacher coordinator;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="leader_id", referencedColumnName = "id")
    private User leader;

    @OneToMany(mappedBy="club")
    @JsonIgnore
    private List<Event> events;

}
