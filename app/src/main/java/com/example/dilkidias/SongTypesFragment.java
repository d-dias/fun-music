package com.example.dilkidias.funmusic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongTypesFragment extends Fragment {


    public SongTypesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.songs_grid, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.grid_view_text);
        textView.setText(R.string.description_types);

        final ArrayList<Grid> grid = new ArrayList<>();
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));
        grid.add(new Grid(getString(R.string.classic_music), R.drawable.classical_music));

        GridView gridView = (GridView) rootView.findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(getActivity(), grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grid grid_items = grid.get(position);

                Intent intent = new Intent(getActivity(), ListedActivity.class);
                intent.putExtra(getString(R.string.type), getString(R.string.song_types));
                intent.putExtra(getString(R.string.text), grid_items.getText());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
