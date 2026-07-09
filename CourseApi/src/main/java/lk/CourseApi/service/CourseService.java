package lk.CourseApi.service;

import lk.CourseApi.controller.request.CourseRequest;
import lk.CourseApi.controller.response.CourseResponse;
import java.util.List;

public interface CourseService {

    public void addCourse(Long id, CourseRequest courseRequest);

    public CourseResponse getCourseById(Long topicId, Long courseId);

    public List<CourseResponse> getAllCourses(Long topicId);

    public void updateById(Long courseId, CourseRequest courseRequest);

    public void deleteById( Long courseId);


    
}
