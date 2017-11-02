package com.example.dilkidias.funmusic;

/**
 * Created by DILKI DIAS on 01-May-17.
 */

public class Songs {

    private String mSong;
    private String mArtist;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Songs(String Song, String Artist, int ImageResourceId, int AudioResourceId) {
        mSong = Song;
        mArtist = Artist;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }


    public String getSong() {
        return mSong;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
