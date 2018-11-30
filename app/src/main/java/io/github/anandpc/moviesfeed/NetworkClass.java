package io.github.anandpc.moviesfeed;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import io.github.anandpc.moviesfeed.Model.Article;
import io.github.anandpc.moviesfeed.Model.News;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
*   https://newsapi.org/v2/top-headlines?country=in&apiKey=f40740e5a3784961861353e9fdcb17dc
*
*  API_KEY =  f40740e5a3784961861353e9fdcb17dc
*
* */

public class NetworkClass {

    RecyclerView recyclerView;
    Context context;

    public NetworkClass(Context context,RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public void getDataFeed() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCall apiCall = retrofit.create(ApiCall.class);

        //  Response of Responsebody type
        Call<News> responseBody = apiCall.getData();

        responseBody.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {
                    News news = response.body();

                     ArrayList<Article> articles = (ArrayList<Article>) news.getArticles();
                    FeedDataAdapter adapter = new FeedDataAdapter(context,articles);

                    LinearLayoutManager manager = new LinearLayoutManager(context);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(manager);

                } else {

                    // Alerting the user if no response is been received.
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Error in Resonse");
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                // Alerting the user if no response is been received.
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("No Internet Connection");
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });


    }
}
