package com.example.dilkidias.funmusic;

/**
 * Created by DILKI DIAS on 02-May-17.
 */

public class Grid {

    private String mText;
    private int mImageResourceId;

    public Grid(String Text, int ImageResourceId) {
        mText = Text;
        mImageResourceId = ImageResourceId;
    }

    public String getText() {
        return mText;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
