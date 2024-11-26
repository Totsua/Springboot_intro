package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/hello")
    public static String hello(){
        return "Hello there!";
    }

    Person bob = new Person("Bob Belcher",46,"bob@aol.com",
            "USA","Burgers");

    @GetMapping("/person")
    public  Person sendBob(){
        return bob;
    }
}
