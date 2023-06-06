package com.sprinklrFeddit.makingRedditApi.Entity.EntitiesFetchedRedditData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Children {


    @JsonProperty("data")
    private DataUser dataUser;


    public Children() {

    }

    public Children(DataUser dataUser) {
        this.dataUser = dataUser;
    }

    public DataUser getDataUser() {
        return dataUser;
    }

    public void setDataUser(DataUser dataUser) {
        this.dataUser = dataUser;
    }


}
