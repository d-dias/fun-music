package com.example.dilkidias.funmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by DILKI DIAS on 30-Apr-17.
 */

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        final ArrayList<Grid> grid = new ArrayList<>();
        grid.add(new Grid(getString(R.string.all_songs), R.drawable.hiphop_music));
        grid.add(new Grid(getString(R.string.artists ), R.drawable.pop_music));
        grid.add(new Grid(getString(R.string.song_types), R.drawable.rock_music));
        grid.add(new Grid(getString(R.string.recently_played), R.drawable.metal_music));

        final GridView gridView = (GridView) findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(SearchActivity.this, grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int tab_number = 0;
                Intent intent = new Intent(SearchActivity.this, FragmentActivity.class);
                Grid grid_position = grid.get(position);
                switch (grid_position.getText()) {
                    case "All songs":
                        tab_number = 0;
                        break;
                    case "Artists":
                        tab_number = 1;
                        break;
                    case "Song types":
                        tab_number = 2;
                        break;
                    case "Recently played":
                        tab_number = 3;
                        break;
                }
                intent.putExtra(getString(R.string.tab_number), tab_number);
                startActivity(intent);
            }
        });

    }
}

