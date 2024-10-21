package com.example.nationalnews;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nationalnews.Articles;
import com.example.nationalnews.NewsRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private NewsRepository newsRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
    }

    //Live Data
    //recently changed
    public LiveData<List<Articles>> getAllArticles(String country , String category){
        return newsRepository.getMutableLiveData(country , category);
    }
}
