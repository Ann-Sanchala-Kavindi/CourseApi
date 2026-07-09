package lk.CourseApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.CourseApi.controller.request.TopicRequest;
import lk.CourseApi.controller.response.TopicResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import lk.CourseApi.service.TopicService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @GetMapping("/topics")
    public List<TopicResponse>  getAllTopics(){

        return topicService.getAllTopics();
  
    }

    @GetMapping("/topics/{id}")
    public TopicResponse getTopic(@PathVariable Long id){

        return topicService.getTopic(id);
    
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody TopicRequest topicRequest){

        topicService.addTopic(topicRequest);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable Long id,
                            @RequestBody TopicRequest topicRequest){


        topicService.updateTopic(id,topicRequest);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Long id){

        topicService.deleteTopic(id);
    }
   
}
