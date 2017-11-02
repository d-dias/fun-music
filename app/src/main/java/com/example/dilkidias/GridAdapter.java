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
 * Created by DILKI DIAS on 02-May-17.
 */

public class GridAdapter extends ArrayAdapter<Grid>{

    public GridAdapter(@NonNull Context context, ArrayList<Grid> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        Grid currentGrid = getItem(position);

        ImageView image_view = (ImageView) listItemView.findViewById(R.id.image_grid);
        image_view.setImageResource(currentGrid.getImageResourceId());

        TextView text_view = (TextView) listItemView.findViewById(R.id.text_grid);
        text_view.setText(currentGrid.getText());

        return listItemView;
    }
}
