package com.sprinklrFeddit.makingRedditApi.Entity.EntitiesFetchedRedditData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataUser {
    @JsonProperty("author_fullname")
    private String authorName;
    @JsonProperty("subreddit")
    private String subReddit;


    @JsonProperty("selftext")
    private String text;


    public DataUser(String authorName, String subReddit, String text) {
        this.authorName = authorName;
        this.subReddit = subReddit;
        this.text = text;
    }

    public DataUser() {

    }

    public String getAuthorName() {
        return authorName;
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
