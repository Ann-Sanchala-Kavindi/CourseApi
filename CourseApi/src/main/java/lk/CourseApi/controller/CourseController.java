package lk.CourseApi.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lk.CourseApi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lk.CourseApi.controller.request.CourseRequest;
import lk.CourseApi.controller.response.CourseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final  CourseService courseService;

    @PostMapping("/api/topics/{topicId}/courses")
    public void addCourse(@PathVariable ("topicId") Long id,
                        @RequestBody CourseRequest courseRequest){

                courseService.addCourse(id,courseRequest);
    }

    @GetMapping("/api/topics/{topicId}/courses/{courseId}")
    public CourseResponse getCourseById(@PathVariable Long topicId,
                                        @PathVariable Long courseId){

        return courseService.getCourseById(topicId,courseId);

    }


    @GetMapping("/api/topics/{topicId}/courses")
    public List<CourseResponse> getAllCourses(@PathVariable Long topicId){

        return courseService.getAllCourses(topicId);

    }


    @GetMapping("/api/courses/{courseName}")
    public CourseResponse getCourseByName(@PathVariable String courseName){

        return courseService.getCourseByName(courseName);


    }
    
    @PutMapping("/api/courses/{courseId}")
    public void updateById(@PathVariable Long courseId,
                                 @RequestBody CourseRequest courseRequest){

        courseService.updateById(courseId,courseRequest);
    }

    @DeleteMapping("/api/courses/{courseId}")
    public void deleteById(@PathVariable Long courseId){

        courseService.deleteById(courseId);

    }
        
}
