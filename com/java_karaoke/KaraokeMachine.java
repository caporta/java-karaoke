package com.java_karaoke;

import com.java_karaoke.model.Song;
import com.java_karaoke.model.SongBook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class KaraokeMachine {
  private SongBook mSongBook;
  private BufferedReader mReader;
  private Map<String, String> mMenu;

  public KaraokeMachine(SongBook songBook) {
    mSongBook = songBook;
    mReader = new BufferedReader(new InputStreamReader(System.in));
    mMenu = new HashMap<String, String>();
    mMenu.put("add", "Add a new song to the song book.");
    mMenu.put("choose", "Choose a song to sing!");
    mMenu.put("quit", "Give up and exit the program.");
  }

  private String promptAction() throws IOException {
    System.out.printf("There are %d songs available. Your options are: %n", mSongBook.getSongCount());
    for (Map.Entry<String, String> option : mMenu.entrySet()) {
      System.out.printf("%s - %s %n", option.getKey(), option.getValue());
    }
    System.out.print("What do you want to do?  ");
    String selection = mReader.readLine();
    return selection.trim().toLowerCase();
  }

  public void run() {
    String selection = "";
    do {
      try {

        selection = promptAction();
        switch (selection) {
          case "add":
            Song song = promptNewSong();
            mSongBook.addSong(song);
            System.out.printf("%s added!  %n%n%n", song);
            break;
          case "choose":
            String artist = promptArtist();
            Song artistSong = promptSongForArtist(artist);
            //TODO: Add to song queue
            System.out.printf("You chose: %s %n", artistSong);
            break;
          case "quit":
            System.out.println("Thanks for playing!");
            break;
          default:
            System.out.printf("Unknown choice: '%s'. Please try again. %n%n%n", selection);
        }

      } catch (IOException ioe) {

        System.out.println("Problem with input");
        ioe.printStackTrace();

      }
    } while (!selection.equals("quit"));
  }

  private Song promptNewSong() throws IOException {
    System.out.print("Enter the artist's name:  ");
    String artist = mReader.readLine();
    System.out.print("Enter the title:  ");
    String title = mReader.readLine();
    System.out.print("Enter the video URL:  ");
    String videoURL = mReader.readLine();
    return new Song(artist, title, videoURL);
  }

  private String promptArtist() throws IOException {
    System.out.print("Available artists:  ");
    List<String> artists = new ArrayList<>(mSongBook.getArtist());
    int index = promptForIndex(artists);
    return artists.get(index);
  }

  private Song promptSongForArtist(String artist) throws IOException {
    List<Song> songs = mSongBook.getSongsForArtist(artist);
    List<String> songTitles = new ArrayList<>();
    for (Song song : songs) {
      songTitles.add(song.getTitle());
    }
    int index = promptForIndex(songTitles);
    return songs.get(index);
  }

  private int promptForIndex(List<String> options) throws IOException {
    int counter = 1;
    for (String option : options) {
      System.out.printf("%d.) %s%n", counter, option);
      counter++;
    }
    String selection = mReader.readLine();
    int selectionIndex = Integer.parseInt(selection.trim());
    System.out.println("Your selection:");
    return selectionIndex - 1;
  }



}




















