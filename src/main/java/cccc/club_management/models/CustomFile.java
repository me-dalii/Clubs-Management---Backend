package cccc.club_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomFile extends AbstractEntity{

    private String fileName;

    @Lob
    private String data;
}
