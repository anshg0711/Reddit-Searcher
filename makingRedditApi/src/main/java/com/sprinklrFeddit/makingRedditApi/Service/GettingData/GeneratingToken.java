package com.sprinklrFeddit.makingRedditApi.Service.GettingData;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class GeneratingToken {
    public static String GettingToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("kdxQ_IM9o-ghFtvDGUSUOg", "lhuUEH1WIS6WXtH4iSRe4B63QIzpWQ");
//        reddit@123
//        Longjumping_Form4980
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.put("User-Agent",
                Collections.singletonList("tomcat:com.e4developer.e4reddit-test:v1.0 (by /u/Longjumping_Form4980)"));
        String body = "grant_type=client_credentials";
        HttpEntity<String> request
                = new HttpEntity<>(body, headers);
        String authUrl = "https://www.reddit.com/api/v1/access_token";
        ResponseEntity<String> response = restTemplate.postForEntity(
                authUrl, request, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        try {
            map.putAll(mapper
                    .readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
                    }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
        return String.valueOf(map.get("access_token"));
    }
}