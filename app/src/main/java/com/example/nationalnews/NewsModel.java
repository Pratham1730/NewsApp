package com.example.nationalnews;

import androidx.annotation.NonNull;

import com.example.nationalnews.Articles;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {

    @NonNull
    private String status;

    @NonNull
    @SerializedName("totalResults")
    private int totalNewsCount;

    @NonNull
    @SerializedName("articles")
    private List<Articles> newsList;

    public NewsModel() {
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public int getTotalNewsCount() {
        return totalNewsCount;
    }

    public void setTotalNewsCount(int totalNewsCount) {
        this.totalNewsCount = totalNewsCount;
    }

    @NonNull
    public List<Articles> getNewsList() {
        return newsList;
    }

    public void setNewsList(@NonNull List<Articles> newsList) {
        this.newsList = newsList;
    }

}
