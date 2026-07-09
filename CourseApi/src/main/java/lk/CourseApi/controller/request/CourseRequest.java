package lk.CourseApi.controller.request;

import lombok.Data;

@Data
public class CourseRequest {

    private Long id;

    private String name;
    private String description;
    private Double duration;
    private Double price;
   
}
