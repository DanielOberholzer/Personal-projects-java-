import java.util.Random;
import java.lang.Runnable;
public class Arcade {
    public static void main(String[] args) {
        Thread player1 = new Thread(new Player(10, 0, 0, "", "Ghandi"));
        Thread player2 = new Thread(new Player(10, 0, 0, "", "Nelson Mandella"));
        Thread player3 = new Thread(new Player(10, 0, 0, "", "Penis boy"));
        Thread oliver = new Thread(new Player(10, 0, 0, "", "Oliver"));
        Thread daniel = new Thread(new Player(10, 0, 0, "", "Daniel"));

        player1.start();
        player2.start();
        player3.start();
        oliver.start();
        daniel.start();

    }
}