package lk.CourseApi.service.impl;

import org.springframework.stereotype.Service;
import lk.CourseApi.controller.request.CourseRequest;
import lk.CourseApi.service.CourseService;
import lombok.RequiredArgsConstructor;
import lk.CourseApi.repository.CourseRepository;
import lk.CourseApi.repository.TopicRepository;
import lk.CourseApi.model.Topic;
import lk.CourseApi.model.Course;
import lk.CourseApi.controller.response.CourseResponse;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    
    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;

    @Override
    public void addCourse(Long id, CourseRequest courseRequest) {
        
        Topic topic=topicRepository.findById(id).orElseThrow(

            () -> new RuntimeException("Topic not found with Id " +id)

        );

        Course course=new Course();

        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        course.setPrice(courseRequest.getPrice());
        course.setTopic(topic);
        
        courseRepository.save(course);

    }

    @Override
    public CourseResponse getCourseById(Long topicId, Long courseId) {

        Topic topic=topicRepository.findById(topicId).orElseThrow(

            () -> new RuntimeException("Topic not found with Id " +topicId)
        );

        Course course=courseRepository.findById(courseId).orElseThrow(

            () -> new RuntimeException("Course not found with Id " +courseId)
        );

        CourseResponse courseResponse=new CourseResponse();

        courseResponse.setName(course.getName());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setPrice(course.getPrice());
        course.setTopic(topic);

        return courseResponse;
    }

    public List<CourseResponse> getAllCourses(Long topicId){

        Topic topic=topicRepository.findById(topicId).orElseThrow(

            () -> new RuntimeException("Topic not found with Id " +topicId)
        );

        List<Course> courses=courseRepository.findByTopicId(topicId);

        List<CourseResponse> courseResponses=new ArrayList<>();

        for(Course course:courses){

            CourseResponse courseResponse=new CourseResponse();

            courseResponse.setName(course.getName());
            courseResponse.setDescription(course.getDescription());
            courseResponse.setDuration(course.getDuration());
            courseResponse.setPrice(course.getPrice());
            course.setTopic(topic);

            courseResponses.add(courseResponse);

        }

        return courseResponses;
    }

    public void updateById(Long courseId, CourseRequest courseRequest){

        Course course=courseRepository.findById(courseId).orElseThrow(

            () -> new RuntimeException("Course not found with Id " +courseId)
        );

        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        course.setPrice(courseRequest.getPrice());
        

        courseRepository.save(course);
    }

    public void deleteById(Long courseId){

        courseRepository.deleteById(courseId);
    }


   
}
