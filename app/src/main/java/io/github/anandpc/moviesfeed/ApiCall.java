package io.github.anandpc.moviesfeed;


import io.github.anandpc.moviesfeed.Model.CinemaBlendClass;
import io.github.anandpc.moviesfeed.Model.Rss;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("rss_review.php")
    Call<CinemaBlendClass> getData();
}
