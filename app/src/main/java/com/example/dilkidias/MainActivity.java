package com.example.dilkidias.funmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search_button = (Button) findViewById(R.id.search_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        Button all_songs_button = (Button) findViewById(R.id.songs_button_main);
        all_songs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                intent.putExtra(getString(R.string.tab_number), 0);
                startActivity(intent);
            }
        });

        Button artist_button = (Button) findViewById(R.id.artist_button);
        artist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                intent.putExtra(getString(R.string.tab_number), 1);
                startActivity(intent);
            }
        });

        Button song_type_button = (Button) findViewById(R.id.types_button);
        song_type_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                intent.putExtra(getString(R.string.tab_number), 2);
                startActivity(intent);
            }
        });
    }
}
