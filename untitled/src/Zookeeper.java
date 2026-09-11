import java.util.ArrayList;
public class Zookeeper{
    public Zookeeper(){

    }
    public void feedAnimals(ArrayList<Animal> z){
        for(int i=0; i<z.size(); i++){
            Animal feed = z.get(i);
            System.out.println("feeding the " + feed.type);

        }

    }
}
