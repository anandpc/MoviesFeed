package io.github.anandpc.moviesfeed;

import android.util.Log;
import io.github.anandpc.moviesfeed.Model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class NetworkClass {

    private final static String NO_RESPONSE_ERROR = "No Response Error";
    private final static String URL = "https://newsapi.org/v2/";
    private final static String TAG = "NetworkClass";

    void getDataFeed() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<News> request = apiInterface.getData();

        request.enqueue(new Callback<News>() {

            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {
                    News news = response.body();
                    MainActivity mainActivity = new MainActivity();
                    mainActivity.loadDownloadedData(news);
                }else {
                    Log.i(TAG,NO_RESPONSE_ERROR);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i(TAG,NO_RESPONSE_ERROR);
            }
        });
    }
}
