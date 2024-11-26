package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.dao.CityInformationDAO;
import com.northcoders.demospringbootapp.model.Person;
import com.northcoders.demospringbootapp.model.Results;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/hello")
    public static String hello() {
        return "Hello there!";
    }

    Person bob = new Person("Bob Belcher", 46, "bob@aol.com",
            "USA", "Burgers");

    @GetMapping("/person")
    public Person sendBob() {
        return bob;
    }

    @GetMapping("/citydetails")
    public Results getCityDetails(@RequestParam String name){
        return CityInformationDAO.cityLongitudeAndLatitude(name);
    }
}
