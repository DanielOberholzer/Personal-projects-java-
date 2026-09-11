import java.util.Random;
import java.lang.Runnable;
public class BasketBallShootout implements Runnable{
    static public boolean BasketBallShootoutIsTaken = false;
    static final Object BasketBallLock = new Object(); // <- SHARED LOCK
    int reward = 0;
    Random random = new Random();

    @Override
    public void run() {

    }
    Player player;
    public void playBasketBallShootout(Player player) throws InterruptedException{
        synchronized (BasketBallLock) {
            while(BasketBallShootoutIsTaken){
                System.out.println(player.getName() + "Waiting for Basketball shoutout...");
                BasketBallLock.wait();
            }

            while (player.tokens != 0) {
                System.out.println(player.getName() + " Is playing Basketball Shootout!");
                player.setTokens(player.tokens - 1);
                System.out.println(player.getName() + " Has " + player.getTokens() + " tokens left");
                BasketBallShootoutIsTaken = true;
                Thread.sleep(2000);
                while (true) {
                    reward = random.nextInt(100);
                    if (reward != 0) break;
                }
                player.setTickets(player.tickets + reward);
                System.out.println(player.getName() + " is finished on Basketball Shootout! They have been awarded " + reward + " tickets, and now have a total of " + player.tickets + "tickets.");
                BasketBallShootoutIsTaken = false;
                BasketBallLock.notifyAll();
                break;
            }
        }

    }
}


