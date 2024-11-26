package com.northcoders.demospringbootapp.dao;

import com.northcoders.demospringbootapp.model.ResultsMeteo;
import com.northcoders.demospringbootapp.model.ResultsSunriseSunset;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class SunriseSunsetDAO {

    private static String urlBuild = "https://api.sunrisesunset.io/json?lat=";


    public static ResultsSunriseSunset getSunriseSunsetTime(String latitude,String longitude){
        String url = urlBuild + latitude + "&lng=" + longitude;
        return webClientConnector(url);
    }

    private static ResultsSunriseSunset webClientConnector(String url){
        WebClient client = WebClient.create(url);
        ResultsSunriseSunset responseBody;

        try{
            responseBody = client.get()
                    .retrieve()
                    .bodyToMono(ResultsSunriseSunset.class)
                    .block();
            return responseBody;
        }catch (WebClientResponseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }
}


