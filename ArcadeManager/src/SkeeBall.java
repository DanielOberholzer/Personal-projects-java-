import java.util.Random;
import java.lang.Runnable;
public class SkeeBall implements Runnable{
    static public boolean SkeeBallIsTaken = false;
    static final Object skeeBallLock = new Object();
    int reward = 0;
    Random random = new Random();

    @Override
    public void run() {

    }
    Player player;
    public void playSkeeBall(Player player) throws InterruptedException{
        synchronized (skeeBallLock) {
            while(SkeeBallIsTaken){
                System.out.println(player.getName() + "Waiting for SkeeBall...");
                skeeBallLock.wait();
            }

            while (player.tokens != 0) {
                System.out.println(player.getName() + " Is playing SkeeBall!");
                player.setTokens(player.tokens - 1);
                System.out.println(player.getName() + " Has " + player.getTokens() + " tokens left");
                SkeeBallIsTaken = true;
                Thread.sleep(2000);
                while (true) {
                    reward = random.nextInt(100);
                    if (reward != 0) break;
                }
                player.setTickets(player.tickets + reward);
                System.out.println(player.getName() + " is finished on SkeeBall! They have been awarded " + reward + " tickets, and now have a total of " + player.tickets + "tickets.");
                SkeeBallIsTaken = false;
                skeeBallLock.notifyAll();
                break;
            }
        }

    }
}

