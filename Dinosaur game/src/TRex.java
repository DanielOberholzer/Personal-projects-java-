import java.util.Scanner;
import java.util.Random;
public class TRex extends Dinosaur{
    public TRex(String name, boolean male, int aggression, int hunger, int health){
        super(name, male, aggression, hunger, "T-rex", health);
    }
    Random random = new Random();
    public static TRex genDinoT(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of your new dinosaur: ");
        String name = scanner.nextLine();
        Boolean male = random.nextBoolean();
        int aggression = random.nextInt(101);
        int hunger = random.nextInt(50, 101);
        int health = random.nextInt(50, 101);
        return new TRex(name, male, aggression, hunger, health);
    }
}
