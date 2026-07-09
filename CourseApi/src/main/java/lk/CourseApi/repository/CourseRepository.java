package lk.CourseApi.repository;


import lk.CourseApi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long>{

    Optional <Course>findByName(String name);

    public List<Course> findByTopicId(Long topicId);

    
}

