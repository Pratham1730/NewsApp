package com.example.nationalnews;

import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository extends MainActivity{

    private List<Articles> articles = new ArrayList<>();
    private MutableLiveData<List<Articles>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    private MainActivity mainActivity = new MainActivity();

    public NewsRepository(Application application) {
        this.application = application;
    }

    //recent
    public MutableLiveData<List<Articles>> getMutableLiveData(String country , String Category){

        RestApi restApi = ApiClient.getService();
        Call<NewsModel> call;
        call = restApi.getCategoryNews("in",Category,"b3d70dc82ff14396a6bfd2ccccf1b9b1");

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();

                if (newsModel != null && newsModel.getNewsList() != null){
                    articles = (List<Articles>) newsModel.getNewsList();
                    mutableLiveData.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(getApplicationContext() , "failed" , Toast.LENGTH_LONG).show();
            }
        });
        return mutableLiveData;
    }


}
