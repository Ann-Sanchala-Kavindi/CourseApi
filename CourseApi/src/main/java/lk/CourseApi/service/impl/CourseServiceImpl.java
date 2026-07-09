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

        course.setId(courseRequest.getId());
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

        courseResponse.setId(course.getId());
        courseResponse.setName(course.getName());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setPrice(course.getPrice());
        courseResponse.setTopicName(topic.getName());
        courseResponse.setTopicId(topic.getId());
        

        return courseResponse;
    }

    @Override
    public List<CourseResponse> getAllCourses(Long topicId){

        Topic topic=topicRepository.findById(topicId).orElseThrow(

            () -> new RuntimeException("Topic not found with Id " +topicId)
        );

        List<Course> courses=courseRepository.findByTopicId(topicId);

        List<CourseResponse> courseResponses=new ArrayList<>();

        for(Course course:courses){

            CourseResponse courseResponse=new CourseResponse();

            courseResponse.setId(course.getId());
            courseResponse.setName(course.getName());
            courseResponse.setDescription(course.getDescription());
            courseResponse.setDuration(course.getDuration());
            courseResponse.setPrice(course.getPrice());
            courseResponse.setTopicName(topic.getName());
            courseResponse.setTopicId(topic.getId());

            courseResponses.add(courseResponse);

        }

        return courseResponses;
    }


    @Override
    public CourseResponse getCourseByName(String courseName) {

        Course course= courseRepository.findByName(courseName).orElseThrow(
            () -> new RuntimeException("Given Topic Name Not Found")
        );

        CourseResponse courseResponse=new CourseResponse();

        courseResponse.setId(course.getId());
        courseResponse.setName(course.getName());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setPrice(course.getPrice());

        courseResponse.setTopicId(course.getId());
        courseResponse.setTopicName(course.getName());

        return courseResponse;    
    
    }


    @Override
    public void updateById(Long courseId, CourseRequest courseRequest){

        Course course=courseRepository.findById(courseId).orElseThrow(

            () -> new RuntimeException("Course not found with Id " +courseId)
        );

        course.setId(courseRequest.getId());
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        course.setPrice(courseRequest.getPrice());
        

        courseRepository.save(course);
    }

    @Override
    public void deleteById(Long courseId){

        courseRepository.deleteById(courseId);
    }

    


   
}
