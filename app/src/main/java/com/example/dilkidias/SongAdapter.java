package com.example.dilkidias.funmusic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DILKI DIAS on 01-May-17.
 */

public class SongAdapter extends ArrayAdapter<Songs> {

    public SongAdapter(@NonNull Context context, ArrayList<Songs> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_all_songs, parent, false);

        }

        Songs currentSong = getItem(position);

        TextView songText = (TextView) listItemView.findViewById(R.id.song_view);
        assert currentSong != null;
        songText.setText(currentSong.getSong());

        TextView artistText = (TextView) listItemView.findViewById(R.id.artist_view);
        artistText.setText(currentSong.getArtist());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(currentSong.getImageResourceId());

        return listItemView;
    }
}
