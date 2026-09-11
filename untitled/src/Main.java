import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Animal flume = new Animal("flume", "White human", 20);
        flume.makeSound();
        flume.getInfo();

        System.out.println();

        Lion mufasa = new Lion("Mufasa", "African lion", 8);
        mufasa.makeSound();
        mufasa.getInfo();

        Penguin happy = new Penguin("Happy Feet" , "Dancing penguin" , 2);

        Elephant mogli = new Elephant("Mogli" , "Indian elephant" , 100);

        ArrayList<Animal> zoo = new ArrayList<Animal>();
        zoo.add(flume);
        zoo.add(mufasa);
        zoo.add(happy);
        zoo.add(mogli);

        int zooSize = zoo.size();

        for(int i=0; i<zoo.size(); i++){
            Animal anml = zoo.get(i);
            anml.makeSound();
        }
        Zookeeper bob = new Zookeeper();

        bob.feedAnimals(zoo);

    }
}