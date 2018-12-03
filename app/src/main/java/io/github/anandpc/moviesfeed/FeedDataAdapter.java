package io.github.anandpc.moviesfeed;

import android.content.Context;
import android.content.Intent;
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

public class FeedDataAdapter extends RecyclerView.Adapter<FeedDataAdapter.ViewHolder> {

    private final static String TITLE = "title";
    private final static String DESC = "desc";
    private final static String IMAGE_URL = "imgUrl";

    private final Context context;
    private final ArrayList<Article> articles;

    public FeedDataAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Article article = articles.get(position);

        Picasso.with(context).load(article.getUrlToImage()).placeholder(R.drawable.no_image).into(holder.imageNews);
        holder.textTitle.setText(article.getTitle());
        holder.textDesc.setText(article.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(TITLE, article.getTitle());
                intent.putExtra(DESC, article.getDescription());
                intent.putExtra(IMAGE_URL, article.getUrlToImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageNews;
        final TextView textTitle;
        final TextView textDesc;

        ViewHolder(View itemView) {
            super(itemView);

            imageNews = itemView.findViewById(R.id.imageNews);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);

        }
    }
}
