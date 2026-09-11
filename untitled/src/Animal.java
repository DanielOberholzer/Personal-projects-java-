public class Animal {
    public String name;
    public String type;
    public int age;

    public Animal(String name, String type, int age){
        this.name = name;
        this.type = type;
        this.age = age;

    }
    public void makeSound(){
        System.out.println("now tell me how it feels bawa bawa FLUME baba bawawa");
    }

    public void getInfo(){
        System.out.println("This is " + this.name + ". They are a " + this.type + " and are " + this.age + " years old.");
    }
}


