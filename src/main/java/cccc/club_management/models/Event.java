package cccc.club_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Event extends AbstractEntity{
    private String title;
    private String description;
    private Date eventDate;
    private Date endDate;
    private String place;
    private Long participantsEstimation;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="eventType_id")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;


}
