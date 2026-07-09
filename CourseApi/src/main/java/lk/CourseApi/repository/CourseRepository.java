package lk.CourseApi.repository;

import lk.CourseApi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CourseRepository extends JpaRepository<Course,Long>{

    public List<Course> findByName(String name);

    public List<Course> findByDescription(String description);

    public List<Course> findByTopicId(Long topicId);
    
}

