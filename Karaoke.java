import com.java_karaoke.model.*;
import com.java_karaoke.KaraokeMachine;

public class Karaoke {

  public static void main(String[] args) {
    SongBook songBook = new SongBook();
    KaraokeMachine machine = new KaraokeMachine(songBook);
    machine.run();
  }

}
