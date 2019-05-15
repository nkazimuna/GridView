package com.example.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    TextView name;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        name = (TextView)findViewById(R.id.griddata);
        imageView = (ImageView)findViewById(R.id.imageView);


        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        imageView.setImageResource(intent.getIntExtra("image", 0));
    }
}
