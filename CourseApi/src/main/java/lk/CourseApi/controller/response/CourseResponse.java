package lk.CourseApi.controller.response;


import lombok.Data;

@Data
public class CourseResponse {

    private Long id;

    private String name;
    private String description;
    private Double duration;
    private Double price;

    private String topicName;
    private Long topicId;
   
}
