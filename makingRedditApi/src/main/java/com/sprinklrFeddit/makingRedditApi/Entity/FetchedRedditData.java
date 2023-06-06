package com.sprinklrFeddit.makingRedditApi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprinklrFeddit.makingRedditApi.Entity.EntitiesFetchedRedditData.Data;

//@JsonIgnoreProperties(ignoreUnknown = true), query=> why it didn't worked
public class FetchedRedditData {
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("data")
    private Data data;

    public FetchedRedditData(String kind, Data data) {
        this.kind = kind;
        this.data = data;
    }

    public FetchedRedditData() {}

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}
