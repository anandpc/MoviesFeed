package io.github.anandpc.moviesfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private final static String TITLE = "title";
    private final static String DESC = "desc";
    private final static String IMAGE_URL = "imgUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView activityImage = findViewById(R.id.imageViewActivity);
        TextView activityTitle = findViewById(R.id.textTitleActivity);
        TextView activityDesc = findViewById(R.id.textDescActivity);

        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        String description = intent.getStringExtra(DESC);
        String image = intent.getStringExtra(IMAGE_URL);

        Picasso.with(this).load(image).placeholder(R.drawable.no_image).into(activityImage);
        activityTitle.setText(title);
        activityDesc.setText(description);

    }
}

