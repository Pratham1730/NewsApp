package com.example.nationalnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nationalnews.databinding.NewsListBinding;
import com.example.nationalnews.databinding.NewsListBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.newsViewHolder> {

    private Context context;
    private List<Articles> articlesList;

    public NewsAdapter(Context context, List<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsListBinding newsListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()) , R.layout.news_list , parent , false);

        return new newsViewHolder(newsListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {

        holder.bind(articlesList.get(position));

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class newsViewHolder extends RecyclerView.ViewHolder{
        private NewsListBinding newsListBinding;

        public newsViewHolder(NewsListBinding newsListBinding) {
            super(newsListBinding.getRoot());
            this.newsListBinding = newsListBinding;
            newsListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION){
                        Articles selectedArticle = articlesList.get(position);
                        Intent i = new Intent(context , NewsDetailActivity.class);
                        i.putExtra("article" , selectedArticle);
                        context.startActivity(i);
                    }
                }
            });
        }

        public void bind(Articles articles ) {
            this.newsListBinding.setArticle(articles);
        }
    }
}
