package lk.CourseApi.service;

import java.util.List;
import lk.CourseApi.model.Topic;


public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopic(String id);

    void addTopic(Topic topic);



    
}

 