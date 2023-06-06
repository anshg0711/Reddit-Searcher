package com.sprinklrFeddit.makingRedditApi.Repository;

import com.sprinklrFeddit.makingRedditApi.Entity.StoredRedditData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RedditRepository extends MongoRepository<StoredRedditData, String> {
    List<StoredRedditData> findByauthorName(String authorName);

    List<StoredRedditData> findBytextRegex(String word);

    List<StoredRedditData> deleteByauthorName(String authorName);
}
