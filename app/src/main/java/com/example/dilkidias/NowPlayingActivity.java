package com.example.dilkidias.funmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by DILKI DIAS on 30-Apr-17.
 */

public class NowPlayingActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private boolean isStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing_activity);

        final Intent intent = getIntent();
        String song = intent.getStringExtra(getString(R.string.song));
        String artist = intent.getStringExtra(getString(R.string.artist));

        int imageResourceId = intent.getIntExtra(getString(R.string.imageResourceId), 0);
        final int audioResourceId = intent.getIntExtra(getString(R.string.audioResourceId), 0);

        ImageView imageView = (ImageView) findViewById(R.id.image_playing);
        imageView.setImageResource(imageResourceId);

        TextView song_text = (TextView) findViewById(R.id.song_playing);
        song_text.setText(song);

        TextView artist_text = (TextView) findViewById(R.id.artist_playing);
        artist_text.setText(artist);

        final ImageButton play_button = (ImageButton) findViewById(R.id.play_playing);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isStarted) {
                    mMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, audioResourceId);
                    mMediaPlayer.start();
                    play_button.setImageResource(R.drawable.pause);
                    isStarted = true;
                } else {
                    boolean isPlaying = mMediaPlayer.isPlaying();
                    if (isPlaying) {
                        mMediaPlayer.pause();
                        play_button.setImageResource(R.drawable.play);
                    } else {
                        mMediaPlayer.start();
                        play_button.setImageResource(R.drawable.pause);
                    }
                }

            }
        });

        ImageButton reset_button = (ImageButton) findViewById(R.id.reset_playing);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted) {
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    isStarted = true;
                    play_button.setImageResource(R.drawable.play);
                }
            }
        });

        ImageButton playfoward_button = (ImageButton) findViewById(R.id.playforward_playing);
        playfoward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted) {
                    int currentMovement = mMediaPlayer.getCurrentPosition();
                    if (mMediaPlayer.isPlaying()) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(currentMovement + 500);
                        mMediaPlayer.start();
                    }
                }
            }
        });

    }
}
