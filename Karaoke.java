import com.java_karaoke.model.*;

public class Karaoke {

  public static void main(String[] args) {

    Song song = new Song(
      "Todd Terje",
      "Delorean Dynamite",
      "www.youtube.com/watch?v=LUOIvT9hzD8"
    );
    SongBook songBook = new SongBook();
    System.out.printf("Adding %s %n", song);
    songBook.addSong(song);
    System.out.printf("Your collection contains %d song(s). %n", songBook.getSongCount());
  }

}
