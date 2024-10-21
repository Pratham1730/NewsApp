package com.example.nationalnews;

import com.example.nationalnews.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("top-headlines")
    Call<NewsModel> getAllNews(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsModel> getCategoryNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

    @GET("v2/everything")
    Call<NewsModel> getSearchedTotalNews(@Query("q") String country, @Query("apiKey") String apiKey);
}
