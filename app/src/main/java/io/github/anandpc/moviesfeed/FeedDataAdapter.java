package io.github.anandpc.moviesfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.github.anandpc.moviesfeed.Model.Article;

public class FeedDataAdapter extends RecyclerView.Adapter<FeedDataAdapter.ViewHolder>{

    private Context context;
    ArrayList<Article> articles;

    public FeedDataAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article article = articles.get(position);

        Picasso.with(context).load(article.getUrlToImage()).placeholder(R.drawable.no_image).into(holder.imageMovie);
        holder.textTitle.setText(article.getTitle());
        holder.textDesc.setText(article.getDescription());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageMovie;
        TextView textTitle,textDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            imageMovie = itemView.findViewById(R.id.imageMovie);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);

        }
    }
}
