public class Lion extends Animal{
    public Lion(String lionName, String lionType, int lionAge){
        super(lionName, lionType, lionAge);

    }
    @Override
    public void makeSound(){
        System.out.println("Roar!");
    }
}
