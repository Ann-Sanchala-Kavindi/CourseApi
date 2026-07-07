package lk.CourseApi.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {


    @RequestMapping("/api/hello")
    public String sayHello(){

        return "Welcome to Course Portal";
    }




    
}
