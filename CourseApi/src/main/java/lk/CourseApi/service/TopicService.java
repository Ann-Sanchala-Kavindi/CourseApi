package lk.CourseApi.service;

import java.util.List;
import lk.CourseApi.controller.request.TopicRequest;
import lk.CourseApi.controller.response.TopicResponse;


public interface TopicService {

    List<TopicResponse> getAllTopics();

    TopicResponse getTopic(Long id);

    void addTopic(TopicRequest topicRequest);

    void updateTopic(Long id, TopicRequest topicRequest);

    void deleteTopic(Long id);

    
}

 