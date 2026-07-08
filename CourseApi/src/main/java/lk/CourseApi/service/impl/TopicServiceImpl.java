package lk.CourseApi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lk.CourseApi.model.Topic;
import lk.CourseApi.service.TopicService;
import lk.CourseApi.repository.TopicRepository;
import lk.CourseApi.controller.request.TopicRequest;
import lk.CourseApi.controller.response.TopicResponse;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicResponse> getAllTopics() {

        List<Topic> topics=topicRepository.findAll();

        List<TopicResponse> topicResponses=new ArrayList<>();

        for(Topic topic:topics){

            TopicResponse topicResponse=new TopicResponse();

            topicResponse.setId(topic.getId());
            topicResponse.setName(topic.getName()); 
            topicResponse.setDescription(topic.getDescription());

            topicResponses.add(topicResponse);


        }

        return topicResponses;

        
    }


    @Override
    public TopicResponse getTopic(Long id) {

        Topic topic=topicRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Topic not found with Id " +id)
        );

        TopicResponse topicResponse=new TopicResponse();

        topicResponse.setId(topic.getId());
        topicResponse.setName(topic.getName());
        topicResponse.setDescription(topic.getDescription());

        return topicResponse;
   
    }

    @Override
    public void addTopic(TopicRequest topicRequest){

        Topic topic=new Topic();

        //topic.setId(topicRequest.getId());
        topic.setName(topicRequest.getName());
        topic.setDescription(topicRequest.getDescription());

        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(Long id,TopicRequest topicRequest){

        Topic topic=topicRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Topic not found with Id " +id)

        );

        //topic.setId(topicRequest.getId());
        topic.setName(topicRequest.getName());
        topic.setDescription(topicRequest.getDescription());

        topicRepository.save(topic);

        
    }

    @Override
    public void deleteTopic(Long id){

        topicRepository.deleteById(id); 
    }

    


    
}
