import java.util.Scanner;
import java.util.Random;
public class Pterodactyl extends Dinosaur{
    public Pterodactyl(String name, boolean male, int aggression, int hunger, int health){
        super(name, male, aggression, hunger, "Pterodactyl", health);
    }
    Random random = new Random();
    public static Pterodactyl genDinoT(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of your new dinosaur: ");
        String name = scanner.nextLine();
        Boolean male = random.nextBoolean();
        int aggression = random.nextInt(101);
        int hunger = random.nextInt(50, 101);
        int health = random.nextInt(50, 101);
        return new Pterodactyl(name, male, aggression, hunger, health);
    }
}
