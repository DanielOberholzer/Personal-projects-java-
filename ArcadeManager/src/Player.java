import java.util.Random;
import java.lang.Runnable;
public class Player implements Runnable{
    int tokens;
    int gameChoice;
    int tickets;
    String prize;
    String name;
    public Player(int tokens, int gameChoice, int tickets, String prize,String name){
        this.tokens = tokens;
        this.gameChoice = gameChoice;
        this.tickets = tickets;
        this.prize = prize;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getTokens(){
        return this.tokens;
    }
    public int setTokens(int newTokens){
        this.tokens = newTokens;
        return tokens;

    }
    public String setPrize(String newPrize){
        this.prize = newPrize;
        return prize;

    }
    public int setTickets(int newTickets){
        this.tickets = newTickets;
        return tickets;

    }

    public void play() {
        Random random = new Random();
        int tokens = 0;
        while (true) {
            tokens = random.nextInt(11);
            this.setTokens(tokens);
            if (tokens != 0) break;
        }
        while (this.tokens > 0) {
            int gameChoice = 0;
            while (true) {
                gameChoice = random.nextInt(4);
                if (gameChoice != 0) break;
            }
            if (gameChoice == 1) {
                AirHockey airHockey = new AirHockey();
                try {
                    airHockey.playAirHockey(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (gameChoice == 2) {
                BasketBallShootout basketBallShootout = new BasketBallShootout();
                try {
                    basketBallShootout.playBasketBallShootout(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (gameChoice == 3) {
                SkeeBall skeeBall = new SkeeBall();
                try {
                    skeeBall.playSkeeBall(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.name + " has no more tokens! Entering prize shop!");
        if (this.tickets < 100) {
            System.out.println("GET TF OUT YOU LOSER");
            this.setPrize("BANNED");
            System.out.println("Your prize is..." + this.prize);
        } else if (this.tickets >= 100 && this.tickets < 200) {
            System.out.println("Not very good at this are you " + this.name + "?");
            this.setPrize("Gum");
            System.out.println("Your prize is..." + this.prize);
        } else if (200 <= this.tickets && this.tickets < 300) {
            System.out.println("Getting better... Keep practicing " + this.name + ".");
            this.setPrize("Action figure");
            System.out.println("Your prize is..." + this.prize);
        } else if (300 <= this.tickets && this.tickets < 400) {
            System.out.println("Ok, not to shabby" + this.name + "...");
            this.setPrize("Water bottle");
            System.out.println("Your prize is..." + this.prize);
        } else if (400 <= this.tickets && this.tickets < 500) {
            System.out.println("Good job" + this.name + "!");
            this.setPrize("T shirt");
            System.out.println("Your prize is..." + this.prize);
        } else if (500 <= this.tickets && this.tickets < 600) {
            System.out.println(this.name + "! You're above average! Well done!");
            this.setPrize("Cool leather jacket");
            System.out.println("Your prize is..." + this.prize);
        } else if (600 <= this.tickets && this.tickets < 700) {
            System.out.println("Dude... get a job " + this.name);
            this.setPrize("Lego set");
            System.out.println("Your prize is..." + this.prize);
        } else if (700 <= this.tickets && this.tickets < 800) {
            System.out.println("Ok " + this.name + "leave some tickets for the rest of us");
            this.setPrize("My girlfriend");
            System.out.println("Your prize is..." + this.prize);
        } else if (800 <= this.tickets && this.tickets < 900) {
            System.out.println("So we've got a pro in here! Good job " + this.name + "...I guess?");
            this.setPrize("Car");
            System.out.println("Your prize is..." + this.prize);
        } else if (900 <= this.tickets && this.tickets < 1000) {
            System.out.println("Wow, you're one of those heroes, arent you " + this.name + "?");
            this.setPrize("House");
            System.out.println("Your prize is..." + this.prize);
        } else if (this.tickets == 1000) {
            System.out.println("WOW. JUST WOW." + this.name + "...THAT IS LITERALLY PERFECT, YOU GOT THE HIGHEST POSSIBLE SCORE.");
            this.setPrize("SLOPPY TOPPY FROM ME PERSONNALY");
            System.out.println("Your prize is..." + this.prize);
        }else{
            System.out.println("How did you even get here?");
        }
    }



    @Override
    public void run() {
        this.play();

    }
}
