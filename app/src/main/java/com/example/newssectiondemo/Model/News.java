package com.example.newssectiondemo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("newsTitle")
    @Expose
    private String newsTitle;
    @SerializedName("newsImage")
    @Expose
    private String newsImage;
    @SerializedName("newsStory")
    @Expose
    private String newsStory;
    @SerializedName("newsTime")
    @Expose
    private String newsTime;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsStory() {
        return newsStory;
    }

    public void setNewsStory(String newsStory) {
        this.newsStory = newsStory;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }
}