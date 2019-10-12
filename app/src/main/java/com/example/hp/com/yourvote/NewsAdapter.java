package com.example.hp.com.yourvote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context mCtx;
    private List<News> newsList;

    public NewsAdapter(Context mCtx, List<News> newsList) {
        this.mCtx = mCtx;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_news,null);
        NewsHolder holder = new NewsHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
            News news=newsList.get(i);

            newsHolder.textViewTitle.setText(news.getTitle());
            newsHolder.textViewDesc.setText(news.getShortDesc());
            newsHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(news.getImage()));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle,textViewDesc;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.news_image);
            textViewTitle=itemView.findViewById(R.id.news_title);
            textViewDesc=itemView.findViewById(R.id.news_description);
        }
    }
}
