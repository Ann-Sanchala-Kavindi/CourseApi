package lk.CourseApi.controller.response;

import lombok.Data;

@Data
public class CourseResponse {

    private String name;
    private String description;
    private Double duration;
    private Double price;

    
}
