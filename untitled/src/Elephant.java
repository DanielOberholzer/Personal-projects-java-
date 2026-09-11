public class Elephant extends Animal{
    public Elephant(String eName, String eType, int eAge){
        super(eName, eType, eAge);

    }
    @Override
    public void makeSound(){
        System.out.println("TOOOOOOOT!");
    }
}

