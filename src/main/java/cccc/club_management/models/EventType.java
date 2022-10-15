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
public class EventType extends AbstractEntity{

    private String title;
    private String description;

    @OneToMany(mappedBy="eventType")
    @JsonIgnore
    private List<Event> events;

}
