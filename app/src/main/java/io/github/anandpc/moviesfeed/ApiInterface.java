package io.github.anandpc.moviesfeed;


import io.github.anandpc.moviesfeed.Model.News;
import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterface {

    @GET("top-headlines?country=in&apiKey=f40740e5a3784961861353e9fdcb17dc")
    Call<News> getData();
}
