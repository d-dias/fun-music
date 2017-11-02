package com.example.dilkidias.funmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DILKI DIAS on 03-May-17.
 */

public class ListedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        Intent intent = getIntent();
        String type = intent.getStringExtra(getString(R.string.type));
        String text = intent.getStringExtra(getString(R.string.text));

        final ArrayList<Songs> song = new ArrayList<>();

        switch (type) {
            case "Song types":
                TextView textView_song_types = (TextView) findViewById(R.id.songs_list_text);
                textView_song_types.setText("All " + text + " musics");
                song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
                song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
                break;

            case "artist":
                TextView textView_artist= (TextView) findViewById(R.id.songs_list_text);
                textView_artist.setText("All songs of " + text);
                song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
                song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
                break;
        }

        ListView listView = (ListView) findViewById(R.id.list);
        SongAdapter adapter = new SongAdapter(ListedActivity.this, song);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs songs = song.get(position);

                Intent intent = new Intent(ListedActivity.this, NowPlayingActivity.class);
                intent.putExtra(getString(R.string.song), songs.getSong());
                intent.putExtra(getString(R.string.artist), songs.getArtist());
                intent.putExtra(getString(R.string.imageResourceId), songs.getImageResourceId());
                intent.putExtra(getString(R.string.audioResourceId), songs.getAudioResourceId());
                startActivity(intent);
            }
        });
    }

}
