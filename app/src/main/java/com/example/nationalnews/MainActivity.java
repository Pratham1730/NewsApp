package com.example.nationalnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.nationalnews.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Articles> articles;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private NewsAdapter newsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private Button healthButton;
    private Button scienceButton;
    private Button businessButton;
    private Button technologyButton;
    private Button sportsButton;
    private Button generalButton;
    public  String country;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


        healthButton = findViewById(R.id.health_button);
        scienceButton = findViewById(R.id.science_button);
        technologyButton = findViewById(R.id.technology_button);
        businessButton = findViewById(R.id.business_button);
        sportsButton = findViewById(R.id.sports_button);
        generalButton = findViewById(R.id.general_button);


        generalButton.setOnClickListener(this);
        healthButton.setOnClickListener(this);
        scienceButton.setOnClickListener(this);
        technologyButton.setOnClickListener(this);
        businessButton.setOnClickListener(this);
        sportsButton.setOnClickListener(this);


        String country = "in";

        String category = "general";
        getNews(country , category);

    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.country_menu , menu);
        return true;
    }

    // Menu Functionality
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.list_item_USA){
            country = "us";
        }
        if (itemId == R.id.list_item_UK){
            country = "uk";
        }
        return super.onOptionsItemSelected(item);
    }

    //recent
    private void getNews(String country , String category) {

        mainActivityViewModel.getAllArticles(country , category).observe(this, new Observer<List<Articles>>() {
            @Override
            public void onChanged(List<Articles> articlesFromLiveData) {
                articles = (List<Articles>) articlesFromLiveData;
                ShowOnRecyclerView();
            }
        });

    }

//    public void categoryClicked(View view){
//        String category = "health";
//        getNews(category);
//    }

    private void ShowOnRecyclerView() {

        recyclerView = activityMainBinding.rvNews;
        newsAdapter = new NewsAdapter(this , articles);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String category = btn.getTag().toString();
        getNews(country ,category);
    }

    private void refresh(){
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
        recreate();
    }
}