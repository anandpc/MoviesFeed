package io.github.anandpc.moviesfeed;


import io.github.anandpc.moviesfeed.Model.Item;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("rss_review.php")
    Call<Item> getData();

    @GET("rss_review.php")
    Call<ResponseBody> getResponseBody();
}
