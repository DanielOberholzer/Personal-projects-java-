import java.util.Random;
import java.lang.Runnable;
import java.lang.Object;
public class AirHockey implements Runnable{
    static public boolean AirHockeyIsTaken = false;
    static final Object airHockeyLock = new Object(); // <- SHARED LOCK
    int reward = 0;
    Random random = new Random();

    @Override
    public void run() {

    }
    Player player;
    public void playAirHockey(Player player) throws InterruptedException{
        synchronized (airHockeyLock) {
            while(AirHockeyIsTaken){
                System.out.println(player.getName() + "Waiting for the air hockey...");
                airHockeyLock.wait();
            }

            while (player.tokens != 0) {
                System.out.println(player.getName() + " Is playing air hockey!");
                player.setTokens(player.tokens - 1);
                System.out.println(player.getName() + " Has " + player.getTokens() + " tokens left");
                AirHockeyIsTaken = true;
                Thread.sleep(2000);
                while (true) {
                    reward = random.nextInt(100);
                    if (reward != 0) break;
                }
                player.setTickets(player.tickets + reward);
                System.out.println(player.getName() + " is finished on the Air Hockey! They have been awarded " + reward + " tickets, and now have a total of " + player.tickets + "tickets.");
                AirHockeyIsTaken = false;
                airHockeyLock.notifyAll();
                break;
            }
        }

    }
}
