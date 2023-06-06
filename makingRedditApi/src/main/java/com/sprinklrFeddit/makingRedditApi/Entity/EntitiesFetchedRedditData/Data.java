package com.sprinklrFeddit.makingRedditApi.Entity.EntitiesFetchedRedditData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("children")
    private Children children[];

    public Children[] getChildren() {
        return children;
    }

    public Data() {

    }

    public Data(Children[] children) {
        this.children = children;
    }

    public void setChildren(Children[] children) {
        this.children = children;
    }


}
