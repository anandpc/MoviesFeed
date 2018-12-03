package io.github.anandpc.moviesfeed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import io.github.anandpc.moviesfeed.Model.Article;
import io.github.anandpc.moviesfeed.Model.News;

public class MainActivity extends AppCompatActivity {

    private final static String INTERNET_ERROR = "Internet Error";
    private final static String CLOSE = "Close";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    FeedDataAdapter adapter;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        if (checkNetwork()) {
            downlaodNewsData();
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(INTERNET_ERROR);
            builder.setNegativeButton(CLOSE, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
    }

    public void downlaodNewsData() {
        NetworkClass networkClass = new NetworkClass();
        networkClass.getDataFeed();
    }

    public void loadDownloadedData(News news) {

        ArrayList<Article> articles = (ArrayList<Article>) news.getArticles();

        adapter = new FeedDataAdapter(this, articles);

        manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    public boolean checkNetwork() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null && cm.getActiveNetworkInfo().isAvailable()) {
            return true;
        }
        return false;
    }
}
