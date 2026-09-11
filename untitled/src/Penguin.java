public class Penguin extends Animal{
    public Penguin(String pName, String pType, int pAge){
        super(pName, pType, pAge);

    }
    @Override
    public void makeSound(){
        System.out.println("Quack!");
    }
}
