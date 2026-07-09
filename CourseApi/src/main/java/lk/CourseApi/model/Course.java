package lk.CourseApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double duration;
    private Double price;

    @ManyToOne
    private Topic topic;




    
    
}
