package com.vks.isdown.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    private final UUID id;
    private String title;
    private final String url;

    public Video(@JsonProperty("id") UUID id, @JsonProperty("title") String title, @JsonProperty("url") String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

}
