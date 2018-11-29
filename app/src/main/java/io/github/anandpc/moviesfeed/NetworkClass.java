package io.github.anandpc.moviesfeed;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import io.github.anandpc.moviesfeed.Model.CinemaBlendClass;
import io.github.anandpc.moviesfeed.Model.Rss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class NetworkClass {
    CinemaBlendClass cinemaBlendClass;
    RecyclerView recyclerView;

    public NetworkClass(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    void getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cinemablend.com/")
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();

        ApiCall apiCall = retrofit.create(ApiCall.class);

        Call<CinemaBlendClass> data = apiCall.getData();

        data.enqueue(new Callback<CinemaBlendClass>() {
            @Override
            public void onResponse(Call<CinemaBlendClass> call, Response<CinemaBlendClass> response) {

                if (response.isSuccessful())
                {
                    CinemaBlendClass data = response.body();

                }
                else
                {
                    Log.i("Error", "error in resp");
                }
            }

            @Override
            public void onFailure(Call<CinemaBlendClass> call, Throwable t) {
                Log.i("failed","Failure");

            }

        });

    }

}
