package com.sprinklrFeddit.makingRedditApi.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprinklrFeddit.makingRedditApi.Entity.EntitiesFetchedRedditData.Children;
import com.sprinklrFeddit.makingRedditApi.Entity.FetchedRedditData;
import com.sprinklrFeddit.makingRedditApi.Entity.StoredRedditData;
import com.sprinklrFeddit.makingRedditApi.Service.GettingData.GettingDataUsingGeneratedToken;
import com.sprinklrFeddit.makingRedditApi.Repository.RedditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RedditService {
    private final RedditRepository redditRepository;

    public RedditService(RedditRepository redditRepository) {
        this.redditRepository = redditRepository;
    }

    public String gettingReddits(String subReddit) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String redditData = GettingDataUsingGeneratedToken.GettingDataUsingGeneratedToken(subReddit);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            FetchedRedditData mappedData = objectMapper.readValue(redditData, FetchedRedditData.class);


            for (Children child : mappedData.getData().getChildren()) {
                this.redditRepository.save(new StoredRedditData(UUID.randomUUID().toString(), child.getDataUser().getAuthorName(), child.getDataUser().getSubReddit(), child.getDataUser().getText()));
            }
            return redditData;
        } catch (Exception e) {

            return e.toString();
        }

    }

    public List<StoredRedditData> getRedditByAuthorName(String authorName) {
        return this.redditRepository.findByauthorName(authorName);
    }

    public String deleteStoredRedditData() {
        this.redditRepository.deleteAll();
        return "Deleted Successfully";
    }

    public List<StoredRedditData> getAllReddits() {
        return this.redditRepository.findAll();
    }

    public List<StoredRedditData> getAllRedditsContaining(String keyword) {
        return this.redditRepository.findBytextRegex(keyword);
    }

    public List<StoredRedditData> deleteAllRedditsBy(String authorName) {
        return this.redditRepository.deleteByauthorName(authorName);

    }
}
