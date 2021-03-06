package com.java_karaoke.model;

public class Song {
  protected String mArtist;
  protected String mTitle;
  protected String mVideoURL;

  public Song(String artist, String title, String videoURL) {
    mArtist = artist;
    mTitle = title;
    mVideoURL = videoURL;
  }

  public String getArtist() {
    return mArtist;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getVideoURL() {
    return mVideoURL;
  }

  @Override
  public String toString() {
    return String.format("Song: %s by %s", mTitle, mArtist);
  }
}
