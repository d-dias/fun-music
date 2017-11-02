package com.example.dilkidias.funmusic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllSongsFragment extends Fragment {


    public AllSongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.songs_list, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.songs_list_text);
        textView.setText(R.string.description_all_songs);

        final ArrayList<Songs> song = new ArrayList<>();
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));
        song.add(new Songs(getString(R.string.song_1), getString(R.string.artist_1), R.drawable.image, R.raw.shape_of_you));


        ListView listView = (ListView) rootView.findViewById(R.id.list);
        SongAdapter adapter = new SongAdapter(getActivity(), song);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs songs = song.get(position);

                Intent intent = new Intent(getActivity(), NowPlayingActivity.class);
                intent.putExtra(getString(R.string.song), songs.getSong());
                intent.putExtra(getString(R.string.artist), songs.getArtist());
                intent.putExtra(getString(R.string.imageResourceId), songs.getImageResourceId());
                intent.putExtra(getString(R.string.audioResourceId), songs.getAudioResourceId());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
