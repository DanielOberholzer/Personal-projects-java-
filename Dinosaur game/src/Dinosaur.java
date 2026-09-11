import java.util.ArrayList;
import java.util.List;
import java.lang.Runnable;
public class Dinosaur implements Runnable {
    String name;
    Boolean male;
    int aggression;
    int hunger;
    String species;
    int health;

    public Dinosaur(String name, Boolean male, int aggression, int hunger, String species, int health) {
        this.name = name;
        this.male = male;
        this.aggression = aggression;
        this.hunger = hunger;
        this.species = species;
        this.health = health;
        allDinos.add(this);
    }
    public static Dinosaur findByName(String searchName) {
        for (Dinosaur d : allDinos) {
            if (d.name.equalsIgnoreCase(searchName)) {
                return d;
            }
        }
        return null; // not found
    }
    static List<Dinosaur> allDinos = new ArrayList<>();

    public void getHungry() throws InterruptedException {
        while (this.health > 0) {
            Thread.sleep(3000);
            this.hunger --;
            if(hunger == 10){
                System.out.println(this.name + " is hungry!");
            } else if (hunger <= 0) {
                System.out.println(this.name + " is starving! :(");
                 this.health -= 1;
                 Thread.sleep(3000);


            }
        }
    }
    public void healthMonitor() throws InterruptedException{
        while(true){
            Thread.sleep(3000);
            if(health == 20){
                System.out.println(this.name + " is low health!");
            } else if (health <= 0) {
                System.out.println(this.name + " has died :(");
                allDinos.remove(this);
                break;

            }
        }
    }


    @Override
    public void run() {
        // Start hunger tracking in its own thread
        Thread hungerThread = new Thread(() -> {
            try {
                this.getHungry();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        hungerThread.start();  // <- this starts the getHungry() method in a new thread

        // Meanwhile, the current thread continues and runs healthMonitor()
        try {
            this.healthMonitor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void getInfo(){
        if(this.male == true) {
            System.out.println("This is a " + this.species + ". It's name is " + this.name + " and it's a male. It's aggression is " + this.aggression + ". its hunger is " + this.hunger + ", and its health is " + this.health);
        }else{
            System.out.println("This is a " + this.species + ". It's name is " + this.name + " and it's a female. It's aggression is " + this.aggression + ". its hunger is " + this.hunger + ", and its health is " + this.health);

        }
    }

}
