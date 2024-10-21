package com.example.nationalnews;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private MainActivity mainActivity;
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://newsapi.org/v2/";

    //"http://newsapi.org/v2/top-headlines?country=in&category=" + Category + "&apikey=b3d70dc82ff14396a6bfd2ccccf1b9b1";

    public static RestApi getService(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RestApi.class);
    }

}
