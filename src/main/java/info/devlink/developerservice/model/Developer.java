package info.devlink.developerservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Developer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String typeOfDeveloper;
}
