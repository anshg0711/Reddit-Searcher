package com.sprinklrFeddit.makingRedditApi.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RedditData")
public class StoredRedditData {
    @Id

    private String id;

    @Indexed(name = "authorName")
    private String authorName;
    private String subReddit;
    private String text;

    public String getAuthorName() {
        return authorName;
    }

    public StoredRedditData() {}

    public StoredRedditData(String id, String authorName, String subReddit, String text) {
        this.id = id;
        this.authorName = authorName;
        this.subReddit = subReddit;
        this.text = text;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(String subReddit) {
        this.subReddit = subReddit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
