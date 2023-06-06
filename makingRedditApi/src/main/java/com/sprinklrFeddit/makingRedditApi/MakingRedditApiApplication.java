package com.sprinklrFeddit.makingRedditApi;

import com.sprinklrFeddit.makingRedditApi.Service.GettingData.GettingDataUsingGeneratedToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication
public class MakingRedditApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(MakingRedditApiApplication.class, args);

    }

}
