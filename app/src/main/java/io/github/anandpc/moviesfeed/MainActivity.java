package io.github.anandpc.moviesfeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.anandpc.moviesfeed.Model.Article;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        NetworkClass networkClass = new NetworkClass(this,recyclerView);
        networkClass.getDataFeed();

        /*FeedDataAdapter adapter = new FeedDataAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);*/

    }

    public void detailView(View view) {

       // recyclerView.setVisibility(View.INVISIBLE);
        Fragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("fragment");
        transaction.add(R.id.fragHolder,fragment).commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
    }
}
