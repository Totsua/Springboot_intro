package com.northcoders.demospringbootapp.dao;

import com.northcoders.demospringbootapp.model.ResultsMeteo;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class CityInformationDAO {

private static String urlBuild = "https://geocoding-api.open-meteo.com/v1/search?name=";


public static ResultsMeteo cityLongitudeAndLatitude(String city){
    String url = urlBuild + city + "&count=1&language=en&format=json";
    return webClientConnector(url);
}

    private static ResultsMeteo webClientConnector(String url){
        WebClient client = WebClient.create(url);
        ResultsMeteo responseBody;

        try{
            responseBody = client.get()
                    .retrieve()
                    .bodyToMono(ResultsMeteo.class)
                    .block();
            return responseBody;
        }catch (WebClientResponseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }
}
