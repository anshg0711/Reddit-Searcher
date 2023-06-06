package com.sprinklrFeddit.makingRedditApi.Controller;

import com.sprinklrFeddit.makingRedditApi.Entity.StoredRedditData;
import com.sprinklrFeddit.makingRedditApi.Service.RedditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedditController {
    public final RedditService redditService;

    public RedditController(RedditService redditService) {
        this.redditService = redditService;
    }

    @PostMapping("/insertSubreddits/{subReddit}")
    public String redditBySubreddit(@PathVariable String subReddit) {
        return redditService.gettingReddits(subReddit);
    }

    @DeleteMapping("/deleteReddits")
    public String deleteStoredRedditData() {
        return redditService.deleteStoredRedditData();
    }

    @DeleteMapping("/deleteReddits/{authorName}")
    public List<StoredRedditData> deleteAllRedditsBy(@PathVariable String authorName) {
        return this.redditService.deleteAllRedditsBy(authorName);
    }

    @GetMapping("/fetchAllReddits/author/{authorName}")
    public List<StoredRedditData> getRedditByAuthorName(@PathVariable String authorName) {
        return redditService.getRedditByAuthorName(authorName);
    }

    @GetMapping("/fetchAllReddits")
    public List<StoredRedditData> getAllReddits() {
        return redditService.getAllReddits();
    }

    @GetMapping("/fetchAllReddits/keyword/{keyword}")
    public List<StoredRedditData> getAllRedditsContaining(@PathVariable String keyword) {
        return redditService.getAllRedditsContaining(keyword);
    }
}
