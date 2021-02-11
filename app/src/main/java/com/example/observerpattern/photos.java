package com.example.observerpattern;

public class photos {

    String title;
    String id;
    String url;


    public photos(String title, String id, String url) {
        this.title = title;
        this.id = id;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
