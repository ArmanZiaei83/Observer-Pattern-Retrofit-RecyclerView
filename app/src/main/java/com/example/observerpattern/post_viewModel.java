package com.example.observerpattern;

import android.widget.ImageView;

public class post_viewModel {

    int imageViewInt;
    private String title;
    private String url;

    public post_viewModel(int imageViewInt, String title, String url) {
        this.imageViewInt = imageViewInt;
        this.title = title;
        this.url = url;
    }

    public int getImageView() {
        return imageViewInt;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
