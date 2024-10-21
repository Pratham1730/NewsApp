package com.example.nationalnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.os.Bundle;

import com.example.nationalnews.databinding.ActivityMainBinding;
import com.example.nationalnews.databinding.ActivityNewsDetailBinding;


public class NewsDetailActivity extends AppCompatActivity{

    private Articles article;
    private ActivityNewsDetailBinding activityNewsDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        activityNewsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);

        Intent i = getIntent();

        if (i.hasExtra("article"));
        article = getIntent().getParcelableExtra("article");
        activityNewsDetailBinding.setArticle(article);
    }

}