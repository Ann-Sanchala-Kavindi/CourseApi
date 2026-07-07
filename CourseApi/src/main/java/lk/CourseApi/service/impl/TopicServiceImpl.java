package lk.CourseApi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import lk.CourseApi.model.Topic;
import lk.CourseApi.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {


    private List<Topic> topics=new ArrayList<>(List.of(

        new Topic("T100","Java","Java is a high-level, object-oriented programming language"),
        new Topic("T101","Python","Python is a high-level, interpreted programming language"),
        new Topic("T102","JavaScript","JavaScript is a versatile programming language primarily used for web development"),
        new Topic("T103","Docker","Docker is a platform that allows developers to automate the deployment of applications inside lightweight, portable containers")


    ));

    @Override
    public List<Topic> getAllTopics() {

        return topics;
    }


    @Override
    public Topic getTopic(String id) {

        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

        
    }

    @Override
    public void addTopic(Topic topic){

        topics.add(topic);
    }

    @Override
    public void updateTopic(String id,Topic topic){

        for(int i=0;i<topics.size();i++){

            Topic t=topics.get(i);

            if(t.getId().equals(id)){

                topics.set(i,topic);

                return;
            }
        }
    }

    @Override
    public void deleteTopic(String id){

        topics.removeIf(t -> t.getId().equals(id));    
    }

    


    
}
