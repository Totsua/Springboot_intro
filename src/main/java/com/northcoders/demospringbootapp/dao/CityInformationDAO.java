package com.northcoders.demospringbootapp.dao;

import com.northcoders.demospringbootapp.model.Results;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class CityInformationDAO {

private static String urlBuild = "https://geocoding-api.open-meteo.com/v1/search?name=";


public static Results cityLongitudeAndLatitude(String city){
    String url = urlBuild + city + "&count=1&language=en&format=json";
    return webClientConnector(url);
}

    private static Results webClientConnector(String url){
        WebClient client = WebClient.create(url);
        System.out.println(url);
        Results responseBody;

        try{
            responseBody = client.get()
                    .retrieve()
                    .bodyToMono(Results.class)
                    .block();
            return responseBody;
        }catch (WebClientResponseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }
}
